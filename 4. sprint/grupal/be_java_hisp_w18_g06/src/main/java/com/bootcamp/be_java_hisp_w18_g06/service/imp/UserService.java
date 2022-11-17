package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    //US-001
    @Override
    public void followUser(int userId, int userIdToFollow) {

        if (userId != userIdToFollow) {

            //Traer la lista de usuarios (TODO agregar excepcion notFoundE)
            //Verificar existencia userId y userIdToFollow
            Optional<User> usFollower = userRepository.findUserById(userId);
            Optional<User> usFollowed = userRepository.findUserById(userIdToFollow);

            List<User> userAdded = new ArrayList<>();

            if (usFollowed.isPresent()) {
                if (usFollowed.get().getPosts() != null) {
                    //Agregar a la lista de Followed de userId
                    userAdded.add(usFollowed.get());
                    usFollower.get().setFollowed(userAdded);
                    //Agregar a la lista de Followers de userIdToFollow
                    usFollowed.get().setFollowers(userAdded);
                } else {
                    throw new BadRequestException("No se puede seguir a este usuario, no tiene posts");
                }
            } else {
                throw new BadRequestException("Ese usuario no existe");
            }
        } else {
            throw new BadRequestException("No te podes seguir a vos mismo");
        }
    }

}
