package com.meli.be_java_hisp_w18_g01.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ProductDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class MapperPostToPostDTO extends ObjectMapper {
    @Override
    public <T> T convertValue(Object fromValue, Class<T> toValueType) throws IllegalArgumentException {
        if(toValueType.getName().equals("PostDTO") && fromValue.getClass().getName().equals("Post")){
            Post post = (Post) fromValue;
            ObjectMapper mapper = new ObjectMapper();
            String date = post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ProductDTO productDTO =  mapper.convertValue(post.getProduct(), ProductDTO.class);
            return (T)(new PostDTO(post.getUser().getUser_id(),date,
                     productDTO, post.getCategory(), post.getPrice()));
        }else{
            throw new RuntimeException("MapperPostToPostDTO recibió parametros incorrectos.");
        }
    }
}
