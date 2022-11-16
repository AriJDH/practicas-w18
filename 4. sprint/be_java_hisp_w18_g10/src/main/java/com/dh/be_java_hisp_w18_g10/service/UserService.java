package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.repository.*;
import com.dh.be_java_hisp_w18_g10.util.DTOMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private IProductRepository productRepository;
    private IPostRepository postRepository;
    public UserService(UserRepository userRepository, ProductRepository productRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.postRepository = postRepository;
    }

    public void addPost(PostDTOreq postDTO){
        //TODO implement
        Post post = new Post();
        int userId = postDTO.getUser_id();
        userRepository
                .getUser(userId)
                .getPosts()
                .put(userId, post);

        postRepository.addPost(post);
    }
    @Override
    public void followUser(int userId, int userIdToFollow) {

    }

    @Override
    public UserFollowersCountDTOres getUserFollowersCount(int userId) {
        return null;
    }

    @Override
    public UserFollowersListDTOres getUserFollowerList(int userId) {
       return DTOMapper.mapToUserFollowersRes(userRepository.getUserFollowers(userId));
    }

    @Override
    public UserFollowedDTOres getUserFollowed(int userId) {
        return null;
    }

    @Override
    public void createPost(PostDTOreq postDTO) {

    }

    @Override
    public UserPostsDTOres getUserPosts(int userId) {
        return null;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
    }


}
