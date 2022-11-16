package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.Product;
import com.mercadolibre.socialmeli.exception.BadRequestException;
import com.mercadolibre.socialmeli.repository.IUserRepository;
import com.mercadolibre.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void addPost(PostDtoReq postReq) {
        try {
            Product prod = new Product(postReq.getProduct().getId(),
                    postReq.getProduct().getName(),
                    postReq.getProduct().getType(),
                    postReq.getProduct().getBrand(),
                    postReq.getProduct().getColor(),
                    postReq.getProduct().getNotes());
            Post post = new Post(userRepository.getNextPostId(),
                    postReq.getDate(),
                    postReq.getCategory(),
                    postReq.getPrice(),
                    prod);
            userRepository.createPost(postReq.getUserId(), post);
        } catch (Exception e){
            throw new BadRequestException("Posteo invalido");
        }
    }
}
