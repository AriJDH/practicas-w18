package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.ProductNotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.UserIdNullException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.NotFoundException;
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

    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user1 = userRepository.getUser(userId);
        User user2 = userRepository.getUser(userIdToFollow);

        if(user1 == null){
            throw new NotFoundException("El usuario con el id: "+userId+" no fue encontrado!");
        }
        if(user2 == null){
            throw new NotFoundException("El usuario con el id: "+userId+" no fue encontrado!");
        }

        user1.getFollowed().put(user2.getUserId(),user2);
        user2.getFollowers().put(user1.getUserId(), user1);
    }

    @Override
    public UserFollowersCountDTOres getUserFollowersCount(int userId) {
        User user = userRepository.getUser(userId);
        if(user == null){
            throw new NotFoundException("El usuario con el id: "+userId+" no fue encontrado!");
        }
        return new UserFollowersCountDTOres(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
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
    public void createPost(PostDTOreq postDTOreq) {
        try {
            int userId = postDTOreq.getUser_id();
            int productId = postDTOreq.getProduct().getProduct_id();
            if (userRepository.getUsers().get(userId) == null)
                throw new UserNotFoundException("Usuario no encontrado!");
            if (productRepository.getProductById(productId) == null)
                throw new ProductNotFoundException("Producto no encontrado.");

            Post post = DTOMapper.mapToPost(postDTOreq);

            Integer postId = postRepository.addPost(post);
            userRepository
                    .getUser(userId)
                    .getPosts()
                    .put(postId, post);
        }
        catch (NullPointerException e) {
             throw new UserIdNullException("Atributo null en user");
        }

    }

    @Override
    public UserPostsDTOres getUserPosts(int userId) {
        return null;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        userRepository.getUser(userId).getFollowed().remove(userIdToUnfollow);
    }


}
