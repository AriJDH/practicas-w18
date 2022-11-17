package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia.be_java_hisp_w18_g08.repository.IPostRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements IPostService{
    IPostRepository postRepository;
    IUserRepository userRepository;

    IUserService userService;

    public PostServiceImp(PostRepositoryImp postRepository, UserRepositoryImp userRepository, UserServiceImp userService){
        this.postRepository=postRepository;
        this.userRepository=userRepository;
        this.userService=userService;
    }

    public List<PostDtoRes> getPostSellerListByUserId(Integer userId){
        List<Seller> followed = userService.getFollowedByUserId(userId);
        List<PostDtoRes> postDtoRes = new ArrayList<>();
        LocalDate date = LocalDate.now();
        for(Seller s:followed){
            List<Post> filtrados = s.getPosts().stream().filter(seller-> seller.getDate().isAfter(date.minusDays(15))).collect(Collectors.toList());
            PostDtoRes postDtoRes1 = new PostDtoRes(userId,filtrados);
            postDtoRes.add(postDtoRes1);
        }
        if(postDtoRes.isEmpty())
            throw new NotFoundUserException("User whith id: " + userId +" sellers post not found ");
        return postDtoRes;
    }




}
