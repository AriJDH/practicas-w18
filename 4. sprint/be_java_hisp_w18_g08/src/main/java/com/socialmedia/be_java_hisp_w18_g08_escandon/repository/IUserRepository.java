package com.socialmedia.be_java_hisp_w18_g08_escandon.repository;

import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.User;

import java.util.List;

public interface IUserRepository {
    Seller findSellerById(Integer id);

    String follow (Integer userId, Integer userIdToFollow);

    User getUserByID(Integer userId);

    void createPost(Post post, Integer id);

    String unFollow(Integer userId,Integer userIdToUnfollow);
    List<Post> getAllPromoProductsByCategory(Integer idSeller, Integer category);
}
