package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.*;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.NotFoundException;
import com.mercadolibre.socialmeli2.exception.OrderInvalidException;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    /**
     * US0001
     *
     * @param idFollower
     * @param idFollow
     * @return
     */
    @Override
    public String follow(Integer idFollower, Integer idFollow) {
        if (Objects.equals(idFollower, idFollow))
            throw new IllegalArgumentException("No es posible seguirse a si mismo.");

        User userFollower = userRepository.findById(idFollower);
        if (userFollower == null)
            throw new NotFoundException(idFollower);

        User userToBeFollowed = userRepository.findById(idFollow);
        if (userToBeFollowed == null)
            throw new NotFoundException(idFollow);
        if (!userToBeFollowed.isSeller())
            throw new IllegalArgumentException("No es posible seguir al usuario id " + idFollow + " ya que no es vendedor");

        if (!userFollower.addFollowed(userToBeFollowed))
            throw new IllegalArgumentException("El usuario id " + idFollower + " ya sigue al usuario id " + idFollow);

        return "El usuario " + idFollower + " ahora sigue al usuario " + idFollow;
    }

    /**
     * US0002
     *
     * @param id
     * @return
     */
    @Override
    public SellerFollowerCountDtoRes getCount(Integer id) {
        if (!userRepository.existsById(id)) throw new NotFoundException(id);
        List<User> followers = userRepository.getFollowers(id);
        Integer count = followers.size();

        User user = userRepository.findById(id);

        return new SellerFollowerCountDtoRes(id, user.getName(), count);
    }

    /**
     * US 0003
     *
     * @param id
     * @param order
     * @return
     */
    @Override
    public SellerFollowerListDtoRes getFollowers(Integer id, String order) {
        if (!userRepository.existsById(id)) throw new NotFoundException(id);
        List<User> followers = userRepository.getFollowers(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followers.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new SellerFollowerListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    /**
     * US0004
     *
     * @param id
     * @param order
     * @return
     */
    @Override
    public UserFollowedListDtoRes getFollowed(Integer id, String order) {
        if (!userRepository.existsById(id)) throw new NotFoundException(id);
        User user = userRepository.findById(id);

        List<User> followed = new ArrayList<>(user.getFollowed());
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    private List<UserDtoRes> order(List<UserDtoRes> usersDtosRes, String order) {
        if (order != null && order.equals("name_asc")) {
            return usersDtosRes.stream()
                    .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
                    .collect(Collectors.toList());
        } else if (order != null && order.equals("name_desc")) {
            return usersDtosRes.stream()
                    .sorted(Comparator.comparing(UserDtoRes::getName).reversed())
                    .collect(Collectors.toList());
        } else if (order == null) {
            return usersDtosRes;
        }
        throw new OrderInvalidException();
    }

    /**
     * US0005
     *
     * @param postReq
     */
    @Override
    public String addPost(PostDtoReq postReq) {
        Post post;
        User user = userRepository.findById(postReq.getUserId());
        if (user == null) {
            throw new NotFoundException(postReq.getUserId());
        }
        post = DTOConverter.dtoToEntity(postReq,userRepository.getNextPostId());
        userRepository.createPost(postReq.getUserId(), post);

        return "Post creado correctamente";
    }

    /**
     * US0006 / US0009
     *
     * @param userId
     * @param order
     * @return
     */
    @Override
    public RecentPostsDtoRes getRecentPosts(Integer userId, String order) {
        if (!userRepository.existsById(userId))
            throw new NotFoundException(userId);
        User user = userRepository.findById(userId);
        List<User> followed = new ArrayList<>(user.getFollowed());
        LocalDate now = LocalDate.now();
        LocalDate twoWeeksAgo = now.minusWeeks(2);

        List<PostDtoRes> postsRes = followed.stream()
                .flatMap(u ->
                        u.getPosts().stream()
                                .map(p -> DTOConverter.entityToDto(p, u.getId()))
                )
                .filter(p -> (p.getDate().isAfter(twoWeeksAgo) && p.getDate().isBefore(now.plusDays(1))))
                .collect(Collectors.toList());

        orderByDate(order, postsRes);

        return new RecentPostsDtoRes(userId, postsRes);
    }

    private static void orderByDate(String order, List<PostDtoRes> postsRes) {
        if (order != null && (!order.equals("date_asc") && !order.equals("date_desc"))) {
            throw new OrderInvalidException();
        }

        if (order != null) {
            if (order.equals("date_desc")) {
                postsRes.sort(Comparator.comparing(PostDtoRes::getDate).reversed());
            } else if (order.equals("date_asc")) {
                postsRes.sort(Comparator.comparing(PostDtoRes::getDate));
            }
        }
    }

    /**
     * US0007
     *
     * @param idFollower
     * @param idUnfollow
     * @return
     */
    @Override
    public String unfollow(Integer idFollower, Integer idUnfollow) {
        User userFollower = userRepository.findById(idFollower);
        if (userFollower == null)
            throw new NotFoundException(idFollower);

        if (!userFollower.getFollowed().removeIf(f -> Objects.equals(f.getId(), idUnfollow)))
            throw new NotFoundException("El usuario seguidor con id " + idFollower + " no sigue al usuario id " + idUnfollow);

        return "El usuario " + idFollower + " dejó de seguir al usuario " + idUnfollow;
    }

}
