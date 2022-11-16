package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.util.List;

public interface IUserRepository {
    User findById(Integer userid);

    List<User> selectAll();

    void removeFollower(int idUser, int idFollower);

    void addFollower(int idUser, int idFollower);

    void removeFollowed(int idUser, int idFollowed);

    void addFollowed(int idUser, int idFollowed);
}
