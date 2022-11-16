package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.ICategoryRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
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

    @Override
    public ResponseDTO createPost(RequestPostDTO request) {
        Integer sizeList = iPostRepository.getPostsSizeList() + 1;
        Post newPost = new Post(
                sizeList,
                request.getProduct().getProductName(),
                request.getProduct().getType(),
                request.getProduct().getBrand(),
                request.getProduct().getColor(),
                request.getProduct().getNotes(),
                iCategoryRepository.findCategoryById(request.getCategory()),
                request.getPrice(),
                request.getProduct().getHasPromo(),
                request.getProduct().getDiscount()
        );

        boolean responseAdd = iPostRepository.addPost(newPost);
        if (responseAdd == false) {
            return new ResponseDTO("Error al agregar el post", 400);
        }

        return new ResponseDTO("Post agregado correctamente", 200);
    }

    @Override
    public SellersPostDTO getPostSellet(Integer userId) {
        return null;
    }
}
