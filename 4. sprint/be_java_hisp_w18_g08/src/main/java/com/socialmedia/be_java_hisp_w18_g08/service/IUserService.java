package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

public interface IUserService {
    UserListDTO findUserListBySeller(Integer id);
}
