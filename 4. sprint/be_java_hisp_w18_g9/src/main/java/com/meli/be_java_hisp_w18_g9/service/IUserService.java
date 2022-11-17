package com.meli.be_java_hisp_w18_g9.service;

import org.springframework.http.HttpStatus;

public interface IUserService {
    HttpStatus follow(Integer userId, Integer userIdToFollow) throws Throwable;
}
