package com.meli.be_java_hisp_w18_g9.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    // ? ==================== Attributes ================ ?

    private final ObjectMapper mapper;
    private final IUserRepository userRepository;

    // ? ==================== Methods ================ ?

    /**
     * Allow user follow another user
     *
     * @param userId         user id
     * @param userIdToFollow user id to follow
     * @return HttpStatus
     */
    @Override
    public HttpStatus follow(Integer userId, Integer userIdToFollow) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new BadRequestException("User with " + userId + " doesn't exist"));
        User userToFollow = userRepository.findById(userIdToFollow).orElseThrow(
                () -> new BadRequestException(
                        "user to follow with Id " + userIdToFollow + " doesn't exist"));

        if (user != null && userToFollow != null) {

            if (user.getUserId().equals(userToFollow.getUserId())) {
                throw new BadRequestException("You can't follow yourself");
            }

            if (userToFollow.getProducts() == null || userToFollow.getProducts().size() == 0) {
                throw new BadRequestException("User to follow is not a seller");
            }

            List<User> userList = new ArrayList<>();

            if (!user.getFollowed().isEmpty()) {
                if (user.getFollowed().stream()
                        .filter(f -> f.getUserId().equals(userToFollow.getUserId())).count() > 0) {
                    throw new BadRequestException(
                            "You already follow the user with Id " + userIdToFollow);
                } else {
                    userList = user.getFollowed();
                }
            }

            userList.add(userToFollow);
            user.setFollowed(userList);
            userRepository.update(user);

            userList = new ArrayList<>();
            if (!userToFollow.getFollowers().isEmpty()) {
                userList = userToFollow.getFollowers();
                if (userToFollow.getFollowers().stream()
                        .filter(f -> f.getUserId().equals(user.getUserId())).count() > 0) {
                    throw new BadRequestException(
                            "You already followed by the user with Id " + userId);
                }
            }

            userList.add(user);
            userToFollow.setFollowers(userList);
            userRepository.update(userToFollow);


            return HttpStatus.OK;
        }

        return HttpStatus.BAD_REQUEST;
    }

    // * ====================

    /**
     * Allow user unfollow another user
     *
     * @param userId           user id
     * @param userIdToUnfollow user id to unfollow
     * @return HttpStatus
     */
    @Override
    public HttpStatus unfollow(Integer userId, Integer userIdToUnfollow) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new BadRequestException("User with " + userId + " doesn't exist"));
        User userToUnfollow = userRepository.findById(userIdToUnfollow).orElseThrow(
                () -> new BadRequestException(
                        "user to follow with Id " + userIdToUnfollow + " doesn't exist"));

        if (user != null && userToUnfollow != null) {

            if (user.getUserId().equals(userToUnfollow.getUserId())) {
                throw new BadRequestException("You can't unfollow yourself");
            }

            if (!user.getFollowed().isEmpty()) {
                if (userToUnfollow.getFollowers().stream()
                        .noneMatch(f -> f.getUserId().equals(user.getUserId()))) {
                    throw new BadRequestException(
                            "You don't follow the user with id: " + userIdToUnfollow);
                } else {

                    user.getFollowed().remove(userToUnfollow);
                    userRepository.update(user);

                    userToUnfollow.getFollowers().remove(user);
                    userRepository.update(userToUnfollow);

                }
            } else {
                if (userToUnfollow.getFollowers().stream()
                        .noneMatch(f -> f.getUserId().equals(user.getUserId()))) {
                    throw new BadRequestException(
                            "You don't follow the user with id: " + userIdToUnfollow);
                }
                throw new BadRequestException("You don't follow anyone");
            }

            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    // * ====================

    /**
     * Get followed users by user id
     *
     * @param id user id
     * @return UserFollowedListResponse (Userinfo and list of followed users)
     */
    @Override
    public UserFollowedListResponse findAllFollowed(Integer id) {

        User userWf = userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("user doesn't exist"));

        return new UserFollowedListResponse(id, userWf.getUserName(), userWf.getFollowed().stream()
                .map(user -> new UserSimpleResponse(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList()));

    }

    // * ====================

    /**
     * Get Count of followers have a user
     *
     * @param id user id
     * @return UserFollowersCountResponse (Userinfo and count of followers)
     */
    @Override
    public FollowersCountUserResponse findUserFollowedQuantity(Integer id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new BadRequestException("User with id:" + id + " doesn't exist"));
        Integer userFollowersQuantity = user.getFollowers().size();

        return new FollowersCountUserResponse(id, user.getUserName(), userFollowersQuantity);

    }

    // * ====================

    /**
     * Get followed users by user id and order by name (ASC)
     *
     * @param id user id
     * @return UserFollowedListResponse (Userinfo and list of followed users)
     */
    @Override
    public UserFollowedListResponse findAllFollowedOrderAsc(Integer id) {

        UserFollowedListResponse userFollowedListResponse = findAllFollowed(id);
        userFollowedListResponse.getFollowed()
                .sort(Comparator.comparing(UserSimpleResponse::getUserName));
        return userFollowedListResponse;

    }

    // * ====================

    /**
     * Get followers users by user id and order by name (ASC)
     *
     * @param id user id
     * @return UserFollowedListResponse (Userinfo and list of followers users)
     */
    @Override
    public UserFollowerListResponse findAllFollowerOrderAsc(Integer id) {

        UserFollowerListResponse userFollowedListResponses = findAllFollower(id);
        userFollowedListResponses.getFollowers()
                .sort(Comparator.comparing(UserSimpleResponse::getUserName));
        return userFollowedListResponses;

    }

    // * ====================

    /**
     * Get followers users by user id and order by name (DESC)
     *
     * @param id user id
     * @return UserFollowedListResponse (Userinfo and list of followers users)
     */
    @Override
    public UserFollowerListResponse findAllFollowerOrderDesc(Integer id) {

        UserFollowerListResponse userFollowedListResponses = findAllFollower(id);
        userFollowedListResponses.getFollowers()
                .sort(Comparator.comparing(UserSimpleResponse::getUserName).reversed());
        return userFollowedListResponses;

    }

    // * ==================

    /**
     * Get followed users by user id and order by name (ASC)
     *
     * @param id user id
     * @return UserFollowedListResponse (Userinfo and list of followed users)
     */
    @Override
    public UserFollowedListResponse findAllFollowedOrderDesc(Integer id) {

        UserFollowedListResponse userFollowedListResponse = findAllFollowed(id);
        userFollowedListResponse.getFollowed()
                .sort(Comparator.comparing(UserSimpleResponse::getUserName).reversed());
        return userFollowedListResponse;

    }

    // * ====================

    /**
     * Get followers users by user id
     *
     * @param id user id
     * @return UserFollowerListResponse (Userinfo and list of followers users)
     */
    @Override
    public UserFollowerListResponse findAllFollower(Integer id) {
        User userWf = userRepository.findById(id).orElseThrow(
                () -> new BadRequestException(String.format("User with id %d doesn't exist", id)));

        if (userWf.getProducts().isEmpty()) {
            throw new BadRequestException(String.format("User with id %d is not a seller", id));
        }

        List<UserSimpleResponse> simpleResponses = userWf.getFollowers().stream()
                .map(user -> UserSimpleResponse.builder().userId(user.getUserId())
                        .userName(user.getUserName()).build()).collect(Collectors.toList());
        return UserFollowerListResponse.builder().userId(id).userName(userWf.getUserName())
                .followers(simpleResponses).build();
    }


}
