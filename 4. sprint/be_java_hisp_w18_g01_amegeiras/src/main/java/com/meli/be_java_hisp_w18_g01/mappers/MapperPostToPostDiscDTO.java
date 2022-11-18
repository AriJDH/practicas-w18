package com.meli.be_java_hisp_w18_g01.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.PostDiscDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ProductDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class MapperPostToPostDiscDTO extends ObjectMapper {
    @Override
    public <T> T convertValue(Object fromValue, Class<T> toValueType) throws IllegalArgumentException {
        if(toValueType.getSimpleName().equals("PostDiscDTO") && fromValue.getClass().getSimpleName().equals("Post")){
            Post post = (Post) fromValue;
            ObjectMapper mapper = new ObjectMapper();
            String date = post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ProductDTO productDTO =  mapper.convertValue(post.getProduct(), ProductDTO.class);
            return (T)(new PostDiscDTO(post.getUser().getUser_id(),post.getPost_id(),date,
                    productDTO, post.getCategory(), post.getPrice(),post.getHasPromo(),post.getDiscount()));
        }else{
            throw new RuntimeException("MapperPostToPostDTO recibió parametros incorrectos.");
        }
    }
}
