package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.GenericException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.repository.*;
import com.dh.be_java_hisp_w18_g10.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService implements IAppService {
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;

    public AppService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user = getUser(userId);
        User userToFollow = getUser(userIdToFollow);
        if(userId == userIdToFollow){
            throw new GenericException("Un usuario no se puede seguir a si mismo!");
        }
        if(!userToFollow.getPosts().isEmpty()){
            user.getFollowed().put(userToFollow.getUserId(), userToFollow);
        }else{
            throw new GenericException("El usuario con el id: "+userIdToFollow+" no es un vendedor!");
        }
        userToFollow.getFollowers().put(user.getUserId(), user);
    }

    @Override
    public UserFollowersCountDTOres getUserFollowersCount(int userId) {
        User user = getUser(userId);

        return new UserFollowersCountDTOres(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }

    @Override
    public UserFollowersDTOres getUserFollowers(int userId) {
        User user = getUser(userId);
        List<User> userFollowers = userRepository.getUserFollowers(userId);
        return DTOMapper.mapToFollowersDTO(user, userFollowers);
    }

    @Override
    public UserFollowersDTOres getUserFollowers(int userId, String order) {
        User user = getUser(userId);
        List<User> userFollowers = userRepository.getUserFollowers(userId, order);
        return DTOMapper.mapToFollowersDTO(user, userFollowers);
    }

    @Override
    public UserFollowedDTOres getUserFollowed(int userId) {
        User user = getUser(userId);
        List<User> userFollowed = userRepository.getUserFollowers(userId);
        return DTOMapper.mapToUserFollowed(user, userFollowed);
    }

    @Override
    public UserFollowedDTOres getUserFollowed(int userId, String order) {
        User user = getUser(userId);
        List<User> userFollowed = userRepository.getUserFollowed(userId, order);
        return DTOMapper.mapToUserFollowed(user, userFollowed);
    }

    @Override
    public void createPost(PostDTOreq postDTOreq) {
        int userId = postDTOreq.getUser_id();
        User user = getUser(userId);
        Post post = DTOMapper.mapTo(postDTOreq);
        Integer postId = postRepository.addPost(post);
        post.setPost_id(postId);
        user.getPosts()
            .put(postId, post);
    }

    @Override
    public UserPostsDTOres getUserPosts(int userId) {
        User user = getUser(userId);
        List<Post> posts = postRepository.getUserPostsFilterByDays(userId, 14);
        return DTOMapper.mapToUserPostsDTOres(user, posts);
    }
    @Override
    public UserPostsDTOres getUserPosts(int userId, String order){
        User user = getUser(userId);
        List<Post> posts = postRepository.getUserPostsFilterByDays(userId, 14, order);
        return DTOMapper.mapToUserPostsDTOres(user, posts);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        User user = getUser(userId);
        User userToUnfollow = getUser(userId);
        if (user.getFollowed().containsKey(userIdToUnfollow)) {
            user.getFollowed()
                .remove(userIdToUnfollow);

            userToUnfollow.getFollowers()
                .remove(userId);
        } else
            throw new GenericException("El usuario con el id: " + userId +
                    " no sigue al usuario " + userIdToUnfollow);
    }




    @Override
    public UserPromoPostCountDTOres getUserPromoPostCount(int userId) {
        User user = getUser(userId);
        int promoCount = userRepository.countUserPromoPosts(userId);
        return DTOMapper.mapTo(user, promoCount);
    }
    @Override
    public UserPromoPostsDTOres getUserPromoPosts(int userId) {
        User user = getUser(userId);
        List<Post> promoPosts = userRepository.getPromoPostByUser(userId);
        return DTOMapper.mapToPromoPost(user, promoPosts);
    }

    private User getUser(int userId){
        User user = userRepository.getUser(userId);
        if (user == null)
            throw new UserNotFoundException(userId);
        return user;
    }
    





}
