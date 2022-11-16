package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.repository.IUserRepository;
import com.mercadolibre.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public String follow(Integer userId, Integer userIdToFollow) {
        this.userRepository.follow(userId, userIdToFollow);
        return "El usuario "+userId+" ahora sigue al usuario "+userIdToFollow;
    }

    @Override
    public String unfollow(Integer userId, Integer userIdToFollow) {
        this.userRepository.unfollow(userId, userIdToFollow);
        return "El usuario "+userId+" dejó de seguir al usuario "+userIdToFollow;
    }
}
