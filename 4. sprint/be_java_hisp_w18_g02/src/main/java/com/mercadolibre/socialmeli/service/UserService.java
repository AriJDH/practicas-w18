package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.ProductDto;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
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

    // US 0002
    @Override
    public void addPost(PostDtoReq postReq) {
        Post post;
        Product prod;
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

        } catch (NotFoundException nf){
            throw nf;
        }
        catch (Exception e){
            throw new BadRequestException("Posteo invalido");
        }

    }

    @Override
    public RecentPostsDtoRes getRecentPosts(Integer userId) {
        List<User> followed = userRepository.getFollowed(userId);
        LocalDate now = LocalDate.now();
        LocalDate twoWeeksAgo = now.minusWeeks(2);

        List<PostDtoRes> postsRes = followed.stream()
                .flatMap(f -> f.getPosts().stream())
                .filter(p-> (p.getDate().isAfter(twoWeeksAgo) && p.getDate().isBefore(now.plusDays(1))))
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
        return new RecentPostsDtoRes(userId, postsRes);
    }

    @Override
    public SellerFollowerCountDtoRes getCount(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        Integer count = followers.size();

        User user = userRepository.findById(id);

        return new SellerFollowerCountDtoRes(id, user.getName(), count);
    }

    // US 0003
    @Override
    public SellerFollowerListDtoRes getFollowers(Integer id, String order) {
        List<User> followers = userRepository.getFollowers(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followers.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new SellerFollowerListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    // US 0004
    @Override
    public UserFollowedListDtoRes getFollowed(Integer id, String order) {
        List<User> followed = userRepository.getFollowed(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    @Override
    public String follow(Integer userId, Integer userIdToFollow) {
        this.userRepository.follow(userId, userIdToFollow);
        return "El usuario " + userId + " ahora sigue al usuario " + userIdToFollow;
    }

    @Override
    public String unfollow(Integer userId, Integer userIdToFollow) {
        this.userRepository.unfollow(userId, userIdToFollow);
        return "El usuario " + userId + " dejó de seguir al usuario " + userIdToFollow;
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
}
