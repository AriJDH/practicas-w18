package com.meli.be_java_hisp_w18_g9.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.*;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    // ? ==================== Attributes ================ ?

    private final ObjectMapper mapper;
    private final IUserRepository userRepository;

    // ? ==================== Methods ================ ?

    @Override
    public HttpStatus follow(Integer userId, Integer userIdToFollow) {
        User user = userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User with "+userId+" doesn't exist"));
        User userToFollow = userRepository.findById(userIdToFollow).orElseThrow(()-> new BadRequestException("user to follow with Id "+userIdToFollow+" doesn't exist"));

        if(user != null && userToFollow != null) {

            if(user.getUserId().equals(userToFollow.getUserId()))
                throw new BadRequestException("You can't follow yourself");

            if(userToFollow.getProducts() == null || userToFollow.getProducts().size()==0)
                throw new BadRequestException("User to follow is not a seller");

            List<User> userList = new ArrayList<>();

            //Se verifica si el usuario sigue a alguien
            if (!user.getFollowed().isEmpty()) {
                if (user.getFollowed().stream().filter(f-> f.getUserId().equals(userToFollow.getUserId())).count()> 0) {
                    throw new BadRequestException("You already follow the user with Id "+userIdToFollow);
                }else{
                    userList = user.getFollowed();
                }
            }

            userList.add(userToFollow);
            user.setFollowed(userList);
            userRepository.update(user);

            //Se agrega como seguidor el usuario en la lista del usuario seguido
            userList = new ArrayList<>();
            if (!userToFollow.getFollowers().isEmpty()) {
                userList = userToFollow.getFollowers();
                if (userToFollow.getFollowers().stream().filter(f-> f.getUserId().equals(user.getUserId())).count() > 0) {
                    throw new BadRequestException("You already followed by the user with Id "+userId);
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

    @Override
    public HttpStatus unfollow(Integer userId, Integer userIdToUnfollow) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("User with "+userId+" doesn't exist"));
        User userToUnfollow = userRepository.findById(userIdToUnfollow).orElseThrow(() -> new BadRequestException("user to follow with Id " + userIdToUnfollow + " doesn't exist"));

        if (user != null && userToUnfollow != null) {

            if (user.getUserId().equals(userToUnfollow.getUserId()))
                throw new BadRequestException("You can't unfollow yourself");

            if (!user.getFollowed().isEmpty()) {
                if (userToUnfollow.getFollowers().stream().noneMatch(f -> f.getUserId().equals(user.getUserId()))) {
                    throw new BadRequestException("You don't follow the user with id: " + userIdToUnfollow);
                } else {

                    user.getFollowed().remove(userToUnfollow);
                    userRepository.update(user);

                    userToUnfollow.getFollowers().remove(user);
                    userRepository.update(userToUnfollow);

                }
            }else {
                if(userToUnfollow.getFollowers().stream().noneMatch(f -> f.getUserId().equals(user.getUserId()))){
                    throw new BadRequestException("You don't follow the user with id: " + userIdToUnfollow);
                }
                throw new BadRequestException("You don't follow anyone");
            }

            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public UserFollowedListResponse findAllFollowed(Integer id) {

        User userWf = userRepository.findById(id).orElseThrow(() -> new BadRequestException("user doesn't exist"));

        return new UserFollowedListResponse(id, userWf.getUserName(), userWf.getFollowed().stream()
                .map(user -> new UserSimpleResponse(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList()));

    }

    @Override
    public FollowersCountUserResponse findUserFollowedQuantity(Integer id){

        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("User with id:" + id + " doesn't exist"));
        Integer userFollowersQuantity = user.getFollowers().size();

        return new FollowersCountUserResponse(id,user.getUserName(),userFollowersQuantity);

    }

    @Override
    public UserFollowedListResponse findAllFollowedOrderAsc(Integer id) {

        UserFollowedListResponse userFollowedListResponse = findAllFollowed(id);
        userFollowedListResponse.getFollowed().sort(Comparator.comparing(UserSimpleResponse::getUserName));
        return userFollowedListResponse;

    }

    @Override
    public UserFollowerListResponse findAllFollowerOrderAsc(Integer id) {

        UserFollowerListResponse userFollowedListResponses = findAllFollower(id);
        userFollowedListResponses.getFollowers().sort(Comparator.comparing(UserSimpleResponse::getUserName));
        return userFollowedListResponses;

    }

    @Override
    public UserFollowerListResponse findAllFollowerOrderDesc(Integer id) {

        UserFollowerListResponse userFollowedListResponses = findAllFollower(id);
        userFollowedListResponses.getFollowers().sort(Comparator.comparing(UserSimpleResponse::getUserName).reversed());
        return userFollowedListResponses;

    }

    @Override
    public UserFollowedListResponse findAllFollowedOrderDesc(Integer id) {

        UserFollowedListResponse userFollowedListResponse = findAllFollowed(id);
        userFollowedListResponse.getFollowed().sort(Comparator.comparing(UserSimpleResponse::getUserName).reversed());
        return userFollowedListResponse;

    }

    @Override
    public UserFollowerListResponse findAllFollower(Integer id){
        User userWf = userRepository.findById(id).orElseThrow(() -> new BadRequestException(String.format("User with id %d doesn't exist", id)));

        if(userWf.getProducts().isEmpty()){
            throw new BadRequestException(String.format("User with id %d is not a seller", id));
        }

        List<UserSimpleResponse> simpleResponses = userWf.getFollowers().stream().map(user -> UserSimpleResponse.builder().userId(user.getUserId()).userName(user.getUserName()).build()).collect(Collectors.toList());
        return UserFollowerListResponse.builder().userId(id).userName(userWf.getUserName()).followers(simpleResponses).build();
    }



}
