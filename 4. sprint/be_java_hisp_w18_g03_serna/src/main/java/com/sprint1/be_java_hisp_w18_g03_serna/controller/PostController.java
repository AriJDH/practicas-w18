package com.sprint1.be_java_hisp_w18_g03_serna.controller;

import com.sprint1.be_java_hisp_w18_g03_serna.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.request.RequestPostPromoDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.PostCheaperDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.PromoProductsCountDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03_serna.service.IPostService;
import com.sprint1.be_java_hisp_w18_g03_serna.service.IUserService;
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

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> postPromo(@RequestBody RequestPostPromoDTO requestPostPromoDTO) {
        return new ResponseEntity<ResponseDTO>(postService.postPromo(requestPostPromoDTO),HttpStatus.OK);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> promoCountByUser(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.promoCountByUser(user_id),HttpStatus.OK);
    }

    @GetMapping("{userId}/cheaper")
    public ResponseEntity<PostCheaperDTO> cheaperByUser(@PathVariable Integer userId){
        return new ResponseEntity<>(postService.cheaperByUser(userId),HttpStatus.OK);
    }

}
