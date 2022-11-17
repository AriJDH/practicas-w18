package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.ICategoryRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;
import com.sprint1.be_java_hisp_w18_g03.exception.CreationException;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImp implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public ResponseDTO createPost(RequestPostDTO request) {
        var user = iUserRepository.findById(request.getUserId());
        if (user == null) throw new NoFoundException("The user hasn't being found");
        Integer sizeList = iPostRepository.getPostsSizeList() + 1;
        var category = iCategoryRepository.findCategoryById(request.getCategory());
        if (category == null) throw new NoFoundException("The category hasn't being found");
        var product = new Product(
                request.getProduct().getProductId(),
                request.getProduct().getProductName(),
                request.getProduct().getType(),
                request.getProduct().getBrand(),
                request.getProduct().getColor(),
                request.getProduct().getNotes(),
                category,
                request.getPrice(),
                request.getProduct().getHasPromo(),
                request.getProduct().getDiscount()
        );
        Post newPost = new Post(
                sizeList,
                user,
                request.getDate(),
                product
        );
        boolean responseAdd = iPostRepository.addPost(newPost);
        if (responseAdd == false) throw new CreationException("Error adding the post");
        return new ResponseDTO("Post added successfully", 200);
    }

    @Override
    public SellersPostDTO getPostSellet(Integer userId) {
        return null;
    }
}
