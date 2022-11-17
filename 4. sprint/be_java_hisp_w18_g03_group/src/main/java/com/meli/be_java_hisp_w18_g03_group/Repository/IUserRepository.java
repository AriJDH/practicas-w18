package com.meli.be_java_hisp_w18_g03_group.Repository;

import com.meli.be_java_hisp_w18_g03_group.entity.User;

import java.util.List;

public interface IUserRepository {
    User findById(Integer userid);
    List<User> selectAll();

}
