package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.dto.PostDTOReq;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import com.socialmedia.be_java_hisp_w18_g08.exception.BadRequestException;
import com.socialmedia.be_java_hisp_w18_g08.repository.IPostRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{

    private IPostRepository postRepository;
    private IUserRepository userRepository;

    public PostServiceImp(PostRepositoryImp postRepository, UserRepositoryImp userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(PostDTOReq postDTOReq) {
        User user = userRepository.getUserByID(postDTOReq.getUser_id());
        if(user == null) {
            throw new BadRequestException("The post was not created");
        } else {
            Post post = new Post(postDTOReq.getPost_id(), postDTOReq.getUser_id(), postDTOReq.getProduct(), postDTOReq.getCategory(), postDTOReq.getPrice(), postDTOReq.getDate());
            postRepository.save(post);
        }
    }
}
