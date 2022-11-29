package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.comparators.StringComparatorAsc;
import com.meli.be_java_hisp_w18_g01.comparators.StringComparatorDesc;
import com.meli.be_java_hisp_w18_g01.dtos.*;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDbService userDbService;
    @Override
    public void handleFollow(long userId, long userIdToFollow) {
        User user = userDbService.findById(userId);
        User userToFollow = userDbService.findById(userIdToFollow);
        user.follow(userToFollow);
    }

    @Override
    public void handleUnfollow(long userId, long userIdToUnfollow) {
        User user = userDbService.findById(userId);
        User userToUnfollow = userDbService.findById(userIdToUnfollow);
        user.unFollow(userToUnfollow);
    }

    @Override
    public UserFollowersCountDTO handleGetFollowersCount(long userId) {
        User user = userDbService.findById(userId);
        return new UserFollowersCountDTO(user.getUser_id(), user.getUser_name(), user.getFollowersCount());//TODO: se puede llegar a hacer mas lindo con objectMapper
    }

    @Override
    public UserFollowersInfoDTO handleGetFollowersInfo(long userId, String order) {
        User user = userDbService.findById(userId);
        List<UserDTO> folllowers =  user.getFollowers().stream()
                .map(u->new UserDTO(u.getUser_id(), u.getUser_name()))
                .collect(Collectors.toList());
        return new UserFollowersInfoDTO(user.getUser_id(), user.getUser_name(), sortUsers(folllowers, order));
    }

    @Override
    public UserFollowedInfoDTO handleGetFollowedInfo(long userId, String order) {
        User user = userDbService.findById(userId);
        List<UserDTO> followed =  user.getFollowed().stream()
                .map(u->new UserDTO(u.getUser_id(), u.getUser_name()))
                .collect(Collectors.toList());
        return new UserFollowedInfoDTO(user.getUser_id(), user.getUser_name(), this.sortUsers(followed, order));
    }

    private List<UserDTO> sortUsers(List<UserDTO> users, String order){
        Comparator comp;
        if(order==null)
            return users;
        switch(order){
            case "name_asc":
                comp = new StringComparatorAsc();
                break;
            case "name_desc":
                comp = new StringComparatorDesc();
                break;
            default:
                    throw new BadRequestException("El parámetro " + order + " es inválido.");
        }
        users.sort((u1,u2)->comp.compare(u1.getUser_name(), u2.getUser_name()));
        return users;
    }
}
