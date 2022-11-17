package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserFollowedListDtoRes;
import com.mercadolibre.socialmeli.entity.User;
import com.mercadolibre.socialmeli.repository.IUserRepository;
import com.mercadolibre.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    // US 0002
    @Override
    public SellerFollowerCountDtoRes getCount(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        Integer count = followers.size();

        User user = userRepository.findById(id);

        return new SellerFollowerCountDtoRes(id, user.getName(), count);
    }

    // US 0003
    @Override
    public SellerFollowerListDtoRes getFollowers(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followers.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new SellerFollowerListDtoRes(id, user.getName(), usersDtosRes);
    }

    // US 0004
    @Override
    public UserFollowedListDtoRes getFollowed(Integer id) {
        List<User> followed = userRepository.getFollowed(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
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
