package com.socialmedia.be_java_hisp_w18_Otero.controller;

import com.socialmedia.be_java_hisp_w18_Otero.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.request.PostPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.GenericResdto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.PromoPostCountDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.RankingLikesDto;
import com.socialmedia.be_java_hisp_w18_Otero.service.IPostService;
import com.socialmedia.be_java_hisp_w18_Otero.service.PostServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.PostDtoRes;

@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImp postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<GenericResdto> createPost(@RequestBody PostDtoReq postDTOReq) {
        postService.createPost(postDTOReq);
        return new ResponseEntity<>(new GenericResdto("Post created with success", 200), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostDtoRes> getPostSellerListByUserId(@PathVariable Integer userId,
                                                                @RequestParam(required = false) String order) {
        PostDtoRes response = postService.getPostSellerListByUserId(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<GenericResdto> createPostPromo(@RequestBody PostPromoDtoReq post) {
        postService.createPromoPost(post);
        return new ResponseEntity<>(new GenericResdto("Post-promo created with success", 200), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getSellerPromoPostCount(@RequestParam Integer user_id) {
        return ResponseEntity.ok(postService.getPromoPostCountBySeller(user_id));
    }

    @RequestMapping(value = "/post/like/{post_id}", method = RequestMethod.PUT)
    public ResponseEntity<GenericResdto> addLikeByPostId(@PathVariable Integer post_id) {
        postService.AddlikeToPost(post_id);
        return new ResponseEntity<>(new GenericResdto("Like added to the post with id: " + post_id, 200),
                HttpStatus.OK);
    }

    @GetMapping("post/rankingLikes")
    public ResponseEntity<RankingLikesDto> getRankingLikes(@RequestParam(required = false) String order){
        RankingLikesDto response = postService.getRankingLikes(order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
