package com.meli.be_java_hisp_w18_g01.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private long postCount = 1L;

    @Autowired
    UserDbService userDbService;

    @Override
    public void addPost(PostDTO postDTO) {
        User user = userDbService.findById(postDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try{
            post = new Post(postCount,
                    user,
                    LocalDate.parse(postDTO.getDate()),
                    mapper.convertValue(postDTO.getProduct(), Product.class),
                    postDTO.getCategory(),
                    postDTO.getPrice()
            );
        }catch(Exception e) {
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
    }
}
