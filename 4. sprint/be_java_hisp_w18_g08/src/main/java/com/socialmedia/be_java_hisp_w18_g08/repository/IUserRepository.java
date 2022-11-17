package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;

import java.util.Optional;
import java.util.List;

public interface IUserRepository {
    Seller findSellerById(long id);


    User getUserByID(Integer userId);
}
