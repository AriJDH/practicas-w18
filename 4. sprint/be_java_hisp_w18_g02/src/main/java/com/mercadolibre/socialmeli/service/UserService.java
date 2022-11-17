package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserFollowedListDtoRes;
import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.Product;
import com.mercadolibre.socialmeli.entity.User;
import com.mercadolibre.socialmeli.exception.BadRequestException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.repository.IUserRepository;
import com.mercadolibre.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

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
    public SellerFollowerCountDtoRes getCount(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        Integer count = followers.size();

        User user = userRepository.findById(id);

        return new SellerFollowerCountDtoRes(id, user.getName(), count);
    }

    @Override
    public SellerFollowerListDtoRes getFollowers(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followers.stream()
                .map(u -> new UserDtoRes(id, u.getName()))
                .collect(Collectors.toList());

        return new SellerFollowerListDtoRes(id, user.getName(), usersDtosRes);
    }

    @Override
    public UserFollowedListDtoRes getFollowed(Integer id) {
        List<User> followed = userRepository.getFollowed(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(id, u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), usersDtosRes);
    }

    @Override
    public String follow(Integer userId, Integer userIdToFollow) {
        this.userRepository.follow(userId, userIdToFollow);
        return "El usuario "+userId+" ahora sigue al usuario "+userIdToFollow;
    }

    @Override
    public String unfollow(Integer userId, Integer userIdToFollow) {
        this.userRepository.unfollow(userId, userIdToFollow);
        return "El usuario "+userId+" dejó de seguir al usuario "+userIdToFollow;
    }
}
