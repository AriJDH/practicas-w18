package com.meli.be_java_hisp_w18_g01.services.database;

import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDbServiceImpl implements UserDbService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(()->{
            throw new UserNotFoundException("El usuario " + id + " no existe.");
        });
    }
}
