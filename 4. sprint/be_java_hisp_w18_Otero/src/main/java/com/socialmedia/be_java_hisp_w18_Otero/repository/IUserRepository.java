package com.socialmedia.be_java_hisp_w18_Otero.repository;

import com.socialmedia.be_java_hisp_w18_Otero.entity.Post;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Seller;
import com.socialmedia.be_java_hisp_w18_Otero.entity.User;

public interface IUserRepository {
    Seller findSellerById(Integer id);

    String follow (Integer userId, Integer userIdToFollow);

    User getUserByID(Integer userId);

    void createPost(Post post, Integer id);

    String unFollow(Integer userId,Integer userIdToUnfollow);
}
