package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.CreateUsersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.*;
import com.sprint1.be_java_hisp_w18_g03.exception.CreationException;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundException;
import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sprint1.be_java_hisp_w18_g03.exception.ParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public ResponseDTO follow(Integer userId, Integer userIdToFollow) {
        if(userId.equals(userIdToFollow)){
            throw new ParamException("The user can't follow to himself");
        }

        User user = iUserRepository.findById(userId);
        User userToFollow = iUserRepository.findById(userIdToFollow);

        if (user == null || userToFollow == null) {
            throw new NoFoundException("The user has not being found");
        } else if (userToFollow.getListFollowers().contains(user)) {
            throw new CreationException("User has been already follow");
        } else if (iPostRepository.findByUser(userIdToFollow).size() == 0) {
            throw new CreationException("User has not posts");
        }

        user.getListFollowed().add(userToFollow);
        userToFollow.getListFollowers().add(user);
        return new ResponseDTO("All ok", 200);
    }

    @Override
    public FollowerCountDTO followerCount(Integer userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NoFoundException("The user hasn't being found");
        return new FollowerCountDTO(
                user.getUserId(),
                user.getUserName(),
                user.getListFollowers().size()
        );
    }

    @Override
    public FollowersDTO getFollowersList(Integer userId, String order) {
        User user = iUserRepository.findById(userId);
        if (user == null) {
            throw new NoFoundException("The user hasn't being found");
        }
        if (user.getListFollowers().isEmpty()) {
            throw new NoFoundException("The user hasn't followers");
        }

        if(order == null) {
            return new FollowersDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user
                            .getListFollowers()
                            .stream()
                            .map(i -> new UserDTO(i.getUserId(), i.getUserName()))
                            .collect(Collectors.toList())
            );
        } else {
            return new FollowersDTO(
                    user.getUserId(),
                    user.getUserName(),
                    orderByName(user.getListFollowers(), order)
                            .stream()
                            .map(i -> new UserDTO(i.getUserId(), i.getUserName()))
                            .collect(Collectors.toList())
            );
        }

    }

    @Override
    public FollowedDTO getFollowedList(Integer userId, String order) {
        User user = iUserRepository.findById(userId);
        if (user == null) {
            throw new NoFoundException("The user hasn't being found");
        }

        if(order == null) {
            return new FollowedDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user
                            .getListFollowed()
                            .stream()
                            .map(i -> new UserDTO(i.getUserId(), i.getUserName()))
                            .collect(Collectors.toList())
            );
        } else {
            return new FollowedDTO(
                    user.getUserId(),
                    user.getUserName(),
                    orderByName(user.getListFollowed(), order)
                            .stream()
                            .map(i -> new UserDTO(i.getUserId(), i.getUserName()))
                            .collect(Collectors.toList())
            );
        }
    }

    private List<User> orderByName(List<User> users, String order){
        if(order.equals("name_asc")) {
            return users
                    .stream()
                    .sorted((user1, user2) -> user1.getUserName().compareTo(user2.getUserName()))
                    .collect(Collectors.toList());
        } else if (order.equals("name_desc")) {
            return users
                    .stream()
                    .sorted((user1, user2) -> user2.getUserName().compareTo(user1.getUserName()))
                    .collect(Collectors.toList());
        } else {
            throw new NoFoundException("Param error");
        }
    }

    @Override
    public ResponseDTO unfollow(Integer userId, Integer unfollowId) {
        if(userId.equals(unfollowId)){
            throw new ParamException("The user can't unfollow to himself");
        }
        User user = iUserRepository.findById(userId);
        User userToFollow = iUserRepository.findById(unfollowId);
        if (user == null || userToFollow == null) {
            throw new NoFoundException("The user has not being found");
        } else if (!userToFollow.getListFollowers().contains(user)) {
            throw new CreationException("User has been already unfollow");
        }

        user.getListFollowed().removeIf(u -> u.getUserId().equals(unfollowId));
        userToFollow.getListFollowers().removeIf(u -> u.getUserId().equals(userId));

        return new ResponseDTO("Ok", 200);
    }

    @Override
    public ResponseDTO createUsers(CreateUsersDTO createUsersDTO) {

        //Validar que no existan los usuarios a crear
        for (UserDTO userDTO : createUsersDTO.getUsers()) {

            User user = iUserRepository.findById(userDTO.getUserId());

            if (user != null) {
                throw new CreationException("Existe el usuario con id " + userDTO.getUserId().toString());
            }
        }

        List<User> usersCreated = createUsersDTO.getUsers().stream().map(x -> new User(x.getUserId(), x.getUserName())).collect(Collectors.toList());

        iUserRepository.createUsers(usersCreated);

        return new ResponseDTO("Created success", HttpStatus.OK.value());
    }

    @Override
    public UsersDTO listUsers() {

        List<User> users = iUserRepository.selectAll();

        if (users.isEmpty()) {
            throw new NoFoundException("Users no found");
        }

        List<UserDTO> userDTOs = users.stream().map(x -> new UserDTO(x.getUserId(), x.getUserName())).collect(Collectors.toList());

        return new UsersDTO(userDTOs);
    }
}
