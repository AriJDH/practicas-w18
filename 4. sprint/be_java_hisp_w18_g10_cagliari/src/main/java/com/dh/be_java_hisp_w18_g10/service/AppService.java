package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.GenericException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.repository.*;
import com.dh.be_java_hisp_w18_g10.util.DTOMapper;
import com.dh.be_java_hisp_w18_g10.util.DateHandler;
import com.dh.be_java_hisp_w18_g10.util.TypeOrderHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppService implements IAppService {
    private IUserRepository userRepository;
    private IPostRepository postRepository;

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
    public UserFollowedDTOres getUserFollowed(int userId) {
        User user = getUser(userId);
        List<User> userFollowed = userRepository.getUserFollowers(userId);
        return DTOMapper.mapToUserFollowed(user, userFollowed);
    }

    @Override
    public void createPost(PostDTOreq postDTOreq) {
        int userId = postDTOreq.getUser_id();
        if (userRepository.getUser(userId) == null)
            throw new GenericException("Usuario no encontrado!");

        Post post = DTOMapper.mapTo(postDTOreq);
        Integer postId = postRepository.addPost(post);
        post.setPost_id(postId);

        userRepository
                .getUser(userId)
                .getPosts()
                .put(postId, post);
    }

    @Override
    public UserPostsDTOres getUserPosts(int userId, String order) {
        UserPostsDTOres userPostsDTOres = new UserPostsDTOres();
        User user = getUser(userId);

        if(user.getFollowed().isEmpty()){
            throw new GenericException(String.format("El usuario %s no sigue vendedeores"
                    , user.getUserName()));
        }
        List<PostDTOres> postListRes = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : user.getFollowed().entrySet()) {
            User userVendedor = userRepository.getUser(entry.getKey());
            if(!userVendedor.getPosts().isEmpty()){
                for (Map.Entry<Integer, Post> posts : userVendedor.getPosts().entrySet()){
                    if(DateHandler.showPostRecently(posts.getValue().getDate()))
                        postListRes.add(DTOMapper.mapTo(posts.getValue()));
                }
            }
        }

        if (postListRes.isEmpty()){
            throw new GenericException(
                    String.format("Los vendedores que sigue el usuario %s , no tienen publicaciones en las ultimas 2 semanas",
                            user.getUserName()));
        }

        postListRes = postListRes
                .stream()
                .sorted(Comparator.comparing(PostDTOres::getDate))
                .collect(Collectors.toList());

        if(order == null || order.equals(TypeOrderHelper.DATE_DESC))
            postListRes = postListRes
                .stream()
                .sorted(Comparator.comparing(PostDTOres::getDate).reversed())
                .collect(Collectors.toList());

        userPostsDTOres.setUser_id(userId);
        userPostsDTOres.setPosts(postListRes);
        return userPostsDTOres;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        if (userRepository.getUser(userId) == null) {
            throw new GenericException("El usuario con el id: " + userId + " no fue encontrado!");
        }
        if (userRepository.getUser(userId).getFollowed().containsKey(userIdToUnfollow)) {
            userRepository.getUser(userId).getFollowed().remove(userIdToUnfollow);
        } else
            throw new GenericException("El usuario con el id: " + userId + " no sigue al usuario " + userIdToUnfollow);
    }

    public UserFollowersDTOres getUserFollowers(int userId, String order) {
        UserFollowersDTOres res = getUserFollowers(userId);
        sortUserListBy(res.getFollowers(), order);
        return res;
    }

    @Override
    public UserFollowedDTOres getUserFollowed(int userId, String order) {
        UserFollowedDTOres res = getUserFollowed(userId);
        sortUserListBy(res.getFollowed(), order);
        return res;
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
    
    private void sortUserListBy(List<UserDTOres> userList, String order){
        if(order.equals(TypeOrderHelper.NAME_ASC)){
            userList
                    .sort(Comparator.comparing(UserDTOres::getUser_name));
        }
        else if(order.equals(TypeOrderHelper.NAME_DESC)){
            userList
                    .sort(Comparator.comparing(UserDTOres::getUser_name).reversed());
        }
        else
            throw new GenericException("Parametro no aceptado");
    }



}
