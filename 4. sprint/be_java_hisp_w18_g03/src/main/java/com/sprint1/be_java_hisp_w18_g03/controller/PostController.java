package com.sprint1.be_java_hisp_w18_g03.controller;

import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponsePostDTO;
import com.sprint1.be_java_hisp_w18_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createPost(@RequestBody RequestPostDTO requestPostDTO) {
       return new ResponseEntity<>(postService.createPost(requestPostDTO),HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseDTO> getFollowedOrderedList(@RequestParam String order) {
        //return new ResponseEntity<>(postService.createPost(requestPostDTO),HttpStatus.OK);
        return null;
    }
}
