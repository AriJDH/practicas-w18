package com.bootcamp.be_java_hisp_w18_g06.repository;

import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.PostPromo;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    void createPost(Post post);
    Optional<User> findUserById(int id);
    Optional<User> findUserInList(List<User> list, int idUserInList);
    User getUser(int userId);
    void updateUsers(User userUpdate);

    void createPromoPost(PostPromo promo, int userId);
}
