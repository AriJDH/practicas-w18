package com.meli.be_java_hisp_w18_g03_group.controller;

import com.meli.be_java_hisp_w18_g03_group.dto.request.RequestPostDTO;
import com.meli.be_java_hisp_w18_g03_group.dto.response.ResponseDTO;
import com.meli.be_java_hisp_w18_g03_group.dto.response.SellersPostDTO;
import com.meli.be_java_hisp_w18_g03_group.service.IPostService;
import com.meli.be_java_hisp_w18_g03_group.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private IUserService userService;

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createPost(@RequestBody RequestPostDTO requestPostDTO) {
        return new ResponseEntity<>(postService.createPost(requestPostDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellersPostDTO> getPostSellers(@PathVariable Integer userId,
                                                         @RequestParam(required = false) String order
    ) {
        return ResponseEntity.ok(postService.getPostSellers(userId,order));
    }
}
