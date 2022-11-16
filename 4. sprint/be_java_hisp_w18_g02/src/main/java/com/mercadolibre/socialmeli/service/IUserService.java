package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import org.springframework.stereotype.Service;


public interface IUserService {
    void addPost(PostDtoReq postReq);
}
