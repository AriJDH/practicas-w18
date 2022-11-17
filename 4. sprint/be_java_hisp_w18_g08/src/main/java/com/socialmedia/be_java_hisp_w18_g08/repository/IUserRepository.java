package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

public interface IUserRepository {
    Seller findUserListBySeller(Integer id);
}
