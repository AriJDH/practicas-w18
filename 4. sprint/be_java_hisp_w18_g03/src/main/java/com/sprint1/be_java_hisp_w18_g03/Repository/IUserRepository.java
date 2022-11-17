package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.util.List;

public interface IUserRepository {
    User findById(Integer userid);
    List<User> selectAll();

}
