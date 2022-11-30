package com.socialmedia2.be_java_hisp_w18_g08.repository;

import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;

public interface IUserRepository {
    Seller findSellerById(Integer id);

    String follow (Integer userId, Integer userIdToFollow);

    User getUserByID(Integer userId);

    void createPost(Post post, Integer id);

    String unFollow(Integer userId,Integer userIdToUnfollow);

    void deleteAll();

    void createUser(User user);

    void createSeller(Seller seller);
}
