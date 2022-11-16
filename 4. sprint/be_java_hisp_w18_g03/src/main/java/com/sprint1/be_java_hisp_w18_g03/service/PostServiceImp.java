package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.ICategoryRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (user==null) return null;
        Integer sizeList = iPostRepository.getPostsSizeList() + 1;
        var category = iCategoryRepository.findCategoryById(request.getCategory());
        if (category == null) return null;;
        Post newPost = new Post(
                sizeList,
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
        boolean responseAdd = iPostRepository.addPost(newPost);
        if (responseAdd == false) return null;
        return new ResponseDTO("Post agregado correctamente", 200);
    }

    @Override
    public SellersPostDTO getPostSellet(Integer userId) {
        return null;
    }
}
