package com.meli.be_java_hisp_w18_g9.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    // ? ==================== Attributes ================ ?

    private final ObjectMapper mapper;
    private final IUserRepository userRepository;

    // ? ==================== Methods ================ ?

    @Override
    public HttpStatus follow(Integer userId, Integer userIdToFollow) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("El usuario con Id " + userId + " no existe"));
        User userToFollow = userRepository.findById(userIdToFollow).orElseThrow(() -> new BadRequestException("El usuario a seguir con Id " + userIdToFollow + " no existe"));

        if (user != null && userToFollow != null) {

            if (user.getUserId().equals(userToFollow.getUserId()))
                throw new BadRequestException("No te puedes seguir a ti mismo");

            List<User> userList = new ArrayList<>();
            if (user.getFollowers().size() > 0) {
                if (user.getFollowers().stream().filter(f -> f.getUserId().equals(userToFollow.getUserId())).count() > 0) {
                    throw new BadRequestException("El usuario con el Id " + userIdToFollow + " ya es seguido");
                } else {
                    userList = user.getFollowers();
                }
            }

            userList.add(userToFollow);
            user.setFollowers(userList);
            userRepository.update(user);

            return HttpStatus.OK;
        }

        return HttpStatus.BAD_REQUEST;
    }

    // * ====================

    @Override
    public HttpStatus unfollow(Integer userId, Integer userIdToUnfollow) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("El usuario con Id " + userId + " no existe"));
        User userToUnfollow = userRepository.findById(userIdToUnfollow).orElseThrow(() -> new BadRequestException("El usuario a seguir con Id " + userIdToUnfollow + " no existe"));

        if (user != null && userToUnfollow != null) {

            if (user.getUserId().equals(userToUnfollow.getUserId()))
                throw new BadRequestException("No te puedes dejar de seguir a ti mismo");

            List<User> userList;
            if (user.getFollowers().size() > 0) {
                if (!user.getFollowers().contains(userToUnfollow)) {
                    throw new BadRequestException("No sigues usuario con el Id " + userIdToUnfollow);
                } else {
                    userList = user.getFollowed();
                    System.out.println(userList);
                    userList.remove(userToUnfollow);
                    System.out.println(userList);

                    user.setFollowers(userList);
                    System.out.println(user);
                    userRepository.update(user);

                    userList = userToUnfollow.getFollowers();
                    userList.remove(user);
                    userToUnfollow.setFollowed(userList);
                    userRepository.update(userToUnfollow);
                }
            }

            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public UserFollowedListResponse findAllFollowed(Integer id) {
        User userWf = userRepository.findById(id).orElseThrow(() -> new BadRequestException("Usuario no existe"));

        return mapper.convertValue(userWf, UserFollowedListResponse.class);
    }

    @Override
    public FollowersCountUserResponse findUserFollowedQuantity(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("El usuario con Id " + id + " no existe"));
        Integer userFollowersQuantity = user.getFollowers().size();
        FollowersCountUserResponse userResponse = new FollowersCountUserResponse(id,user.getUserName(),userFollowersQuantity);
        return userResponse;
    }
}
