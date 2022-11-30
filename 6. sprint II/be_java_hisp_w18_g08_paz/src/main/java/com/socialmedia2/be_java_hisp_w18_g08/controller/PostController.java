package com.socialmedia2.be_java_hisp_w18_g08.controller;

import com.socialmedia2.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ResponseMessasgeDto;
import com.socialmedia2.be_java_hisp_w18_g08.service.IPostService;
import com.socialmedia2.be_java_hisp_w18_g08.service.PostServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/products")
@Validated
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImp postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseMessasgeDto> createPost(@Valid @RequestBody PostDtoReq postDTOReq) {
        ResponseMessasgeDto response = new ResponseMessasgeDto(postService.create(postDTOReq), 200, LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostDtoRes> getPostSellerListByUserId(@PathVariable
                                                                @NotNull(message = "El  id no puede estar vacío.")
                                                                @Min(value = 1, message = "El id debe ser mayor a cero")
                                                                Integer userId,
                                                                @RequestParam(required = false) String order) {
        PostDtoRes response = postService.getPostSellerListByUserId(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
