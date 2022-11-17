package com.meli.be_java_hisp_w18_g9.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        User user = userRepository.findById(userId).orElseThrow(()-> new BadRequestException("El usuario con Id "+userId+" no existe"));
        User userToFollow = userRepository.findById(userIdToFollow).orElseThrow(()-> new BadRequestException("El usuario a seguir con Id "+userIdToFollow+" no existe"));

        if(user != null && userToFollow != null) {

            if(user.getUserId().equals(userToFollow.getUserId()))
                throw new BadRequestException("No te puedes seguir a ti mismo");

            if(userToFollow.getProducts() == null || userToFollow.getProducts().size()==0)
                throw new BadRequestException("El usuario a seguir no es un vendedor");

            List<User> userList = new ArrayList<>();

            //Se verifica si el usuario sigue a alguien
            if (user.getFollowed().size() > 0) {
                if (user.getFollowed().stream().filter(f-> f.getUserId().equals(userToFollow.getUserId())).count()> 0) {
                    throw new BadRequestException("El usuario con el Id "+userIdToFollow+" ya es seguido");
                }else{
                    userList = user.getFollowed();
                }
            }

            userList.add(userToFollow);
            user.setFollowed(userList);
            userRepository.update(user);

            //Se agrega como seguidor el usuario en la lista del usuario seguido
            userList = new ArrayList<>();
            if (userToFollow.getFollowers().size() > 0) {
                if (userToFollow.getFollowers().stream().filter(f-> f.getUserId().equals(user.getUserId())).count()> 0) {
                    System.out.println("Usuario ya es seguidor");
                }else{
                    userList = userToFollow.getFollowers();
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
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("El usuario con Id " + userId + " no existe"));
        User userToUnfollow = userRepository.findById(userIdToUnfollow).orElseThrow(() -> new BadRequestException("El usuario a seguir con Id " + userIdToUnfollow + " no existe"));

        if (user != null && userToUnfollow != null) {

            if (user.getUserId().equals(userToUnfollow.getUserId()))
                throw new BadRequestException("No te puedes dejar de seguir a ti mismo");

            List<User> userList;
            if (!user.getFollowed().isEmpty()) {
                if (!user.getFollowed().contains(userToUnfollow)) {
                    throw new BadRequestException("No sigues usuario con el Id " + userIdToUnfollow);
                } else {

                    user.getFollowed().remove(userToUnfollow);
                    userRepository.update(user);

                    userToUnfollow.getFollowers().remove(user);
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

        return new UserFollowedListResponse(id, userWf.getUserName(), userWf.getFollowed().stream()
                .map(user -> new UserSimpleResponse(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList()));

    }

    @Override
    public FollowersCountUserResponse findUserFollowedQuantity(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("El usuario con Id " + id + " no existe"));
        Integer userFollowersQuantity = user.getFollowers().size();
        FollowersCountUserResponse userResponse = new FollowersCountUserResponse(id,user.getUserName(),userFollowersQuantity);
        return userResponse;
    }
}
