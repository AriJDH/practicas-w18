package com.meli.be_java_hisp_w18_g9.service;

import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IEntityRepository;
import com.meli.be_java_hisp_w18_g9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    IEntityRepository userRepository = new UserRepository();

    @Override
    public HttpStatus follow(Integer userId, Integer userIdToFollow) throws Throwable {
        User user = (User) userRepository.findById(userId).orElseThrow(()-> new BadRequestException("El usuario con Id "+userId+" no existe"));
        User userToFollow = (User) userRepository.findById(userIdToFollow).orElseThrow(()-> new BadRequestException("El usuario a seguir con Id "+userIdToFollow+" no existe"));

        if(user != null && userToFollow != null) {

            if(user.getUserId().equals(userToFollow.getUserId()))
                throw new BadRequestException("No te puedes seguir a ti mismo");

            List<User> userList = new ArrayList<>();
            if (user.getFollowers().size() > 0) {
                if (user.getFollowers().stream().filter(f-> f.getUserId().equals(userToFollow.getUserId())).count()> 0) {
                    throw new BadRequestException("El usuario con el Id "+userIdToFollow+" ya es seguido");
                }else{
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
}
