package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.ProductDto;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.request.PromoPostDtoReq;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.Product;
import com.mercadolibre.socialmeli.entity.User;
import com.mercadolibre.socialmeli.exception.BadRequestException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserDtoRes> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());
    }

    /**
     * US0001
     *
     * @param userId
     * @param userIdToFollow
     * @return
     */
    @Override
    public String follow(Integer userId, Integer userIdToFollow) {
        this.userRepository.follow(userId, userIdToFollow);
        return "El usuario " + userId + " ahora sigue al usuario " + userIdToFollow;
    }

    /**
     * US0002
     *
     * @param id
     * @return
     */
    @Override
    public SellerFollowerCountDtoRes getCount(Integer id) {
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
        List<User> followed = userRepository.getFollowed(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    private List<UserDtoRes> order(List<UserDtoRes> usersDtosRes, String order) {
        if (order != null && order.equals("name_asc")) {
            usersDtosRes = usersDtosRes.stream()
                    .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
                    .collect(Collectors.toList());
        } else if (order != null && order.equals("name_desc")) {
            usersDtosRes = usersDtosRes.stream()
                    .sorted(Comparator.comparing(UserDtoRes::getName).reversed())
                    .collect(Collectors.toList());
        }
        return usersDtosRes;
    }

    /**
     * US0005
     *
     * @param postReq
     */
    @Override
    public void addPost(PostDtoReq postReq) {
        addPromoPost(new PromoPostDtoReq(postReq));
    }

    /**
     * US0010
     *
     * @param promoPostReq
     */
    @Override
    public void addPromoPost(PromoPostDtoReq promoPostReq) {
        Post post;
        Product prod;
        try {
            prod = new Product(promoPostReq.getProduct().getId(),
                    promoPostReq.getProduct().getName(),
                    promoPostReq.getProduct().getType(),
                    promoPostReq.getProduct().getBrand(),
                    promoPostReq.getProduct().getColor(),
                    promoPostReq.getProduct().getNotes());
            post = new Post(userRepository.getNextPostId(),
                    promoPostReq.getDate(),
                    promoPostReq.getCategory(),
                    promoPostReq.getPrice(),
                    prod, promoPostReq.isHasPromo(), promoPostReq.getDiscount());
            userRepository.createPost(promoPostReq.getUserId(), post);

        } catch (NotFoundException nf) {
            throw nf;
        } catch (Exception e) {
            throw new BadRequestException("Posteo invalido");
        }
    }

    /**
     * US 0011
     *
     * @param id
     * @return
     */
    public SellerPromoPostsCountDtoRes getPromoPostsCount(Integer id) {
        User user = userRepository.findById(id);
        Integer count = (int)userRepository.getPostsFromSeller(id).stream()
                .filter(p -> p.isHasPromo())
                .count();
        return new SellerPromoPostsCountDtoRes(id, user.getName(), count);
    }

    /**
     * US 0012
     *
     * @param id
     * @return
     */
    @Override
    public SellerPromoPostsDtoRes getPromoPostsFromSeller(Integer id, String order) {
        User user = userRepository.findById(id);

        List<PromoPostDtoRes> promoPostsDtoRes = userRepository.getPostsFromSeller(id).stream()
                .filter(p -> p.isHasPromo())
                .map(p -> new PromoPostDtoRes(id,
                        p.getId(),
                        p.getDate(),
                        new ProductDto(p.getProduct().getId(),
                                p.getProduct().getName(),
                                p.getProduct().getType(),
                                p.getProduct().getBrand(),
                                p.getProduct().getColor(),
                                p.getProduct().getNotes()),
                        p.getCategory(),
                        p.getPrice(),
                        p.isHasPromo(),
                        p.getDiscount()))
                .collect(Collectors.toList());

        if (order != null && order.equals("date_desc")) {
            promoPostsDtoRes.sort(Comparator.comparing(PromoPostDtoRes::getDate).reversed());
        } else if (order != null && order.equals("date_asc")) {
            promoPostsDtoRes.sort(Comparator.comparing(PromoPostDtoRes::getDate));
        }

        return new SellerPromoPostsDtoRes(id, user.getName(), promoPostsDtoRes);
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
        List<User> followed = userRepository.getFollowed(userId);
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
     * @param userId
     * @param userIdToUnfollow
     * @return
     */
    @Override
    public String unfollow(Integer userId, Integer userIdToUnfollow) {
        this.userRepository.unfollow(userId, userIdToUnfollow);
        return "El usuario " + userId + " dejó de seguir al usuario " + userIdToUnfollow;
    }

}
