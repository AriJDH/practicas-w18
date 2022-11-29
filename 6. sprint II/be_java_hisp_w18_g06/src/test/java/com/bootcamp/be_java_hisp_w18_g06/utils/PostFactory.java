package com.bootcamp.be_java_hisp_w18_g06.utils;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostResDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserPostListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFactory {

    private static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build();

    public static Post getPost(int userId) {
        Product product = new Product((int) (Math.random() * 10),
                "nombre prod", "a", "b", "c", "d");
        Post post = new Post(userId, LocalDate.now(), product, "100", 1000.69);
        return post;
    }

    public static UserPostListDTO getPostListDto(int userId) {
        UserPostListDTO userPostListDTO = new UserPostListDTO();
        userPostListDTO.setUser_id(userId);

        List<PostResDto> postList = new ArrayList<>();
        PostResDto postResDto1 = mapper.convertValue(getPost(1), PostResDto.class);
        postResDto1.setPost_id(1);
        PostResDto postResDto2 = mapper.convertValue(getPost(1), PostResDto.class);
        postResDto2.setPost_id(1);
        PostResDto postResDto3 = mapper.convertValue(getPost(1), PostResDto.class);
        postResDto3.setPost_id(1);
        postList.add(postResDto1);
        postList.add(postResDto2);
        postList.add(postResDto3);
        userPostListDTO.setPostDTOList(postList);
        return userPostListDTO;
    }
    public static List<PostDTO> getPostDto(){
        List<PostDTO> postList = new ArrayList<>();
        PostDTO post1 = new PostDTO();
        post1.setDate(LocalDate.now().minusWeeks(1));
        PostDTO post2 = new PostDTO();
        post2.setDate(LocalDate.now());

        postList.add(post1);
        postList.add(post2);
        return postList;

    }
}
