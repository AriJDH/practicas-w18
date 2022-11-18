package com.example.socialmeli.service;

import com.example.socialmeli.dto.response.UserBasicResponse;
import com.example.socialmeli.dto.response.UserFollowedListResponse;
import com.example.socialmeli.dto.response.UserFollowerCountResponse;
import com.example.socialmeli.dto.response.UserFollowersListResponse;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.exception.NotFoundException;
import com.example.socialmeli.repository.interfaces.IUserRepository;
import com.example.socialmeli.service.interfaces.IUserService;
import com.example.socialmeli.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    /**
     * Permite que un usuario comience a seguir a otro usuario. Evalua que ambos usuarios pasados como parametro
     * existan y que el usuario objetivo sea un vendedor o tenga al menos una publicacion
     * @param userId Usuario que va a comenzar a seguir a otro
     * @param userIdToFollow Usuario objetivo a seguir
     */
    @Override
    public void followUserSeller(Integer userId, Integer userIdToFollow) {
        if (!userRepository.exist(userId)) {
            throw new NotFoundException("No existe usuario con ID: " + userId);
        }

        if (!userRepository.exist(userIdToFollow)) {
            throw new NotFoundException("No existe usuario con ID: " + userIdToFollow);
        }

        if (userRepository.isSeller(userIdToFollow)) {
            userRepository.followSeller(userId, userIdToFollow);
        } else {
            throw new NotFoundException("El usuario con ID: " + userIdToFollow + " no es vendedor");
        }
    }
    /**
     * This method is used to unfollow a seller.
     *
     * @param userId the user ID who wants to unfollow a seller
     * @param userIdToUnfollow the seller/user ID to unfollow
     */
    @Override
    public void unfollowUserSeller(Integer userId, Integer userIdToUnfollow) {
        if (!userRepository.exist(userId)) {
            throw new NotFoundException("No existe usuario con ID: " + userId);
        }

        if (!userRepository.exist(userIdToUnfollow)) {
            throw new NotFoundException("No existe usuario con ID: " + userIdToUnfollow);
        }
        userRepository.unfollowSeller(userId, userIdToUnfollow);
    }

    /**
     * This method is used to count the numbers of followers of a User
     *
     * @param userId the User ID to count his followers
     * @return The count of followers
     */
    @Override
    public UserFollowerCountResponse getUserFollowersCount(Integer userId) {
        UserEntity userCount = userRepository.getEntityById(userId);
        return UserMapper.userEntity2UserFollowerCountResponse(userCount);
    }

    /**
     * This method when is called will return a user_id with its user_name
     * and a list of users followed with user_id and user_name.
     * If the user don´t follow anyone, the list will be empty
     *
     * @param userId enter the id of the user that we will retrieve the list of followers
     * @param order Optional. enter the value "name_asc" or "name_desc" to order the list of followed users by user_name
     * @return returns an UserFollowedListResponse object made of userId, userName and List<>UserResponse
     */
    @Override
    public UserFollowersListResponse getFollowersUsersById(Integer userId, String order) {
        UserEntity seller = userRepository.getEntityById(userId);
        List<UserBasicResponse> followersDtos = new ArrayList<>();

        for (Integer followerId : seller.getFollowersList()) {
            UserEntity follower = userRepository.getEntityById(followerId);
            followersDtos.add(UserMapper.userEntity2UserBasicResponse(follower));
        }

        if (order.equals("name_asc")) {
            followersDtos.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        }

        if (order.equals("name_desc")) {
            followersDtos.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
        }

        return UserMapper.userEntity2UserFollowersListResponse(seller,followersDtos);
    }

    /**
     * This method when is called will return a user_id with its user_name
     * and a list of users followed with user_id and user_name.
     * If the user don´t follow anyone, the list will be empty
     *
     * @param id enter the id of the user that we will retrieve the list of followers
     * @param order Optional. enter the value "name_asc" or "name_desc" to order the list of followed users by user_name
     * @return returns an UserFollowedListResponse object made of userId, userName and List<>UserResponse
     */
    @Override
    public UserFollowedListResponse getFollowedUsersById(Integer id, String order) {
        UserEntity entity = userRepository.getEntityById(id);
        List<UserBasicResponse> followedList = new ArrayList<>();

        for (Integer integer : entity.getFollowedList()) {
            followedList.add(UserMapper.userEntity2UserBasicResponse(userRepository.getEntityById(integer)));
        }

        if (order.equals("name_asc")) {
            followedList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        }

        if (order.equals("name_desc")) {
            followedList.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
        }

        return UserMapper.userEntity2UserFollowedListResponse(entity, followedList);
    }

}
