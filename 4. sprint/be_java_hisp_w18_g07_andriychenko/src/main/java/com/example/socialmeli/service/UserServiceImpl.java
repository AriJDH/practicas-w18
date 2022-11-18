package com.example.socialmeli.service;


import com.example.socialmeli.dto.response.*;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.exception.NotFoundException;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public UserFollowedListResponse getFollowedUsersById(Integer id, String order) {

        UserFollowedListResponse response;
        List<UserBasicResponse> followedList = new ArrayList<>();

        UserEntity entity = userRepository.getEntityByID(id);

        for (Integer integer : entity.getFollowedList()) {
            followedList.add(UserMapper.userEntity2UserBasicResponse(userRepository.getEntityByID(integer)));
        }

        if (order.equals("name_asc")){
            followedList.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));
        }

        if (order.equals("name_desc")){
            followedList.sort((p1,p2) -> p2.getName().compareTo(p1.getName()));
        }

        response = UserMapper.entity2UserFollowedListResponse(entity, followedList);

        return response;
    }

    @Override
    public UserFollowersListResponse getUserFollowers(int userId, String order){
        UserEntity seller = userRepository.getEntityByID(userId);
        List<Integer> followerIds = seller.getFollowersList();
        List<UserBasicResponse> followersDtos = new ArrayList<>();

        for (Integer followerId: followerIds
        ) {
            UserEntity follower = userRepository.getEntityByID(followerId);
            followersDtos.add(new UserBasicResponse(follower.getId(),follower.getName()));
        }

        if (order.equals("name_asc")){
            followersDtos.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));
        }

        if (order.equals("name_desc")){
            followersDtos.sort((p1,p2) -> p2.getName().compareTo(p1.getName()));
        }

        return new UserFollowersListResponse(seller.getId(), seller.getName(), followersDtos);
    }



    public UserFollowerCountResponse getUserFollowersCount(int id){
        UserEntity userCount = this.userRepository.getEntityByID(id);
        //Espacio para agregar una excepcion en caso de que UserCount sea null.
        return new UserFollowerCountResponse(userCount.getId(), userCount.getName(), userCount.getFollowersList().size());
    }

    public void unfollowUser(int userId, int userIdToUnfollow){
        UserEntity user = this.userRepository.getEntityByID(userId);
        System.out.println("Removido");
        int i = 0; boolean finded = false;
        while(i < user.getFollowersList().size() && !finded){
            if(user.getFollowersList().get(i) == userIdToUnfollow){
                finded = true;
            }
            i++;
        }
        //Excepcion si no lo encuentra
        user.getFollowersList().remove(i);
    }



    @Override
    public void followSeller(Integer userId, Integer userIdToFollow) {
        if ( userRepository.exist(userIdToFollow) && userRepository.isSeller(userIdToFollow)) {
            userRepository.followSeller(userId, userIdToFollow);
        }else{
            //System.out.println("El usuario a seguir no existe o no es vendedor.");
            throw new NotFoundException("El usuario con ID: " + userIdToFollow +
                    " no es un usuario existente o no es vendedor");
        }
    }
}
