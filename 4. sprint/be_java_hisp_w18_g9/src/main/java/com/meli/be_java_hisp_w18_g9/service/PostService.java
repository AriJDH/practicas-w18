package com.meli.be_java_hisp_w18_g9.service;

import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{
    @Override
    public void addPost(PostDtoRequest postDtoRequest) {
        Product product = new Product(
                postDtoRequest.getProduct().getProductId(),
                postDtoRequest.getProduct().getProductName(),
                postDtoRequest.getProduct().getType(),
                postDtoRequest.getProduct().getBrand(),
                postDtoRequest.getProduct().getColor(),
                postDtoRequest.getProduct().getNotes()
        );
    }
}
