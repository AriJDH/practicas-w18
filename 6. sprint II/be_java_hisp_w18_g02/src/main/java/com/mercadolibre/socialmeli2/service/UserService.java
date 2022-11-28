package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.*;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.Product;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.BadRequestException;
import com.mercadolibre.socialmeli2.exception.NotFoundException;
import com.mercadolibre.socialmeli2.exception.OrderInvalidException;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        //this.userRepository.follow(userId, userIdToFollow);
        if(idFollower == idFollow)
            throw new IllegalArgumentException("No es posible seguirse a si mismo.");

        User userFollower = userRepository.findById(idFollower);
        if(userFollower == null)
            throw new NotFoundException("No se pudo encontrar el usuario seguidor con id "+idFollower);

        User userToBeFollowed = userRepository.findById(idFollow);
        if(userToBeFollowed == null)
            throw new NotFoundException("No se pudo encontrar el usuario a seguir con id "+idFollow);
        if(!userToBeFollowed.isSeller())
            throw new IllegalArgumentException("No es posible seguir al usuario id "+idFollow+" ya que no es vendedor");

        if(!userFollower.addFollowed(userToBeFollowed))
            throw new IllegalArgumentException("El usuario id "+idFollower+" ya sigue al usuario id "+idFollow);

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
        if(!userRepository.existsById(id)) throw new NotFoundException("No se pudo encontrar al usuario " + id);
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
        if(!userRepository.existsById(id)) throw new NotFoundException("No se pudo encontrar al usuario " + id);
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
        if(!userRepository.existsById(id)) throw new NotFoundException("No se pudo encontrar al usuario " + id);
        User user = userRepository.findById(id);

        List<User> followed = new ArrayList<>(user.getFollowed());
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    private List<UserDtoRes> order(List<UserDtoRes> usersDtosRes, String order) {
        if (order != null && order.equals("name_asc")) {
            return  usersDtosRes.stream()
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
        Product prod;
        User user = userRepository.findById(postReq.getUserId());
        if (user ==null) {
            throw new NotFoundException("El usuario "+postReq.getUserId()+" no existe");
        }
        try {
            prod = new Product(postReq.getProduct().getId(),
                    postReq.getProduct().getName(),
                    postReq.getProduct().getType(),
                    postReq.getProduct().getBrand(),
                    postReq.getProduct().getColor(),
                    postReq.getProduct().getNotes());
            post = new Post(userRepository.getNextPostId(),
                    postReq.getDate(),
                    postReq.getCategory(),
                    postReq.getPrice(),
                    prod);
            userRepository.createPost(postReq.getUserId(), post);

        } catch (Exception e) {
            throw new BadRequestException("Posteo invalido");
        }
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
        if(!userRepository.existsById(userId)) throw new NotFoundException("No se pudo encontrar al usuario " + userId);
        User user = userRepository.findById(userId);
        List<User> followed = new ArrayList<>(user.getFollowed());
        LocalDate now = LocalDate.now();
        LocalDate twoWeeksAgo = now.minusWeeks(2);

        List<PostDtoRes> postsRes = followed.stream()
                .flatMap(f -> f.getPosts().stream())
                .filter(p -> (p.getDate().isAfter(twoWeeksAgo) && p.getDate().isBefore(now.plusDays(1))))
                .map(p -> new PostDtoRes(
                        userId,
                        p.getId(),
                        p.getDate(),
                        new ProductDto(p.getProduct().getId(),
                                p.getProduct().getName(),
                                p.getProduct().getType(),
                                p.getProduct().getBrand(),
                                p.getProduct().getColor(),
                                p.getProduct().getNotes()),
                        p.getCategory(),
                        p.getPrice()))
                .collect(Collectors.toList());

        if (order != null && order.equals("date_desc")) {
            postsRes.sort(Comparator.comparing(PostDtoRes::getDate).reversed());
        } else if (order != null && order.equals("date_asc")) {
            postsRes.sort(Comparator.comparing(PostDtoRes::getDate));
        }

        return new RecentPostsDtoRes(userId, postsRes);
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
        if(userFollower == null)
            throw new NotFoundException("No se pudo encontrar el usuario seguidor con id "+idFollower);

        if(!userFollower.getFollowed().removeIf(f -> f.getId()==idUnfollow))
            throw new NotFoundException("El usuario seguidor con id "+idFollower+ " no sigue al usuario id "+idUnfollow);

        return "El usuario " + idFollower + " dejó de seguir al usuario " + idUnfollow;
    }

}
