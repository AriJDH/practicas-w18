package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.dto.PostDTOReq;
import com.socialmedia.be_java_hisp_w18_g08.repository.IPostRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{

    private IPostRepository postRepository;

    public PostServiceImp(PostRepositoryImp postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<PostDTOReq> create(PostDTOReq postDTOReq) {
        Boolean post = postRepository.save( new Post(postDTOReq.getPost_id(), postDTOReq.getUser_id(), postDTOReq.getProduct(), postDTOReq.getCategory(), postDTOReq.getPrice(), postDTOReq.getDate()));
        if (post){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RuntimeException();
        }
    }
}
