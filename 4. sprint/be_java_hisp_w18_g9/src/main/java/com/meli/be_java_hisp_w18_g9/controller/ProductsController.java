package com.meli.be_java_hisp_w18_g9.controller;

import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PromoPostRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PromoPostListByUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PromoProductsCountResponse;
import com.meli.be_java_hisp_w18_g9.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    // ? =============== Attributes =============== ?
    private final IPostService iPostService;

    // ? =============== Methods =============== ?

    // * ===== [GET] ===== *

    @GetMapping("/post")
    public ResponseEntity<List<PostDtoResponse>> findAll() {
        return new ResponseEntity<>(iPostService.findAll(), HttpStatus.OK);
    }

    // * ============== *

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListByFollowedResponse> findFollowedByUserId(@PathVariable Integer userId, @RequestParam(required = false) String order) {

        if(order != null){
            if(order.equals("date_asc")) {
                return new ResponseEntity<>(iPostService.findPostsByFollowedAndUserIdOrderByDateAsc(userId), HttpStatus.OK);
            }else if(order.equals("date_desc")) {
                return new ResponseEntity<>(iPostService.findPostsByFollowedAndUserIdOrderByDateDesc(userId), HttpStatus.OK);
            }else {
                throw new BadRequestException(String.format("The order %s is not valid, please use date_asc or date_desc", order));
            }
        }else{
            return new ResponseEntity<>(iPostService.findPostsByFollowedAndUserId(userId), HttpStatus.OK);
        }
    }


    // * ===== [POST] ===== *

    @PostMapping("/post")
    public ResponseEntity<PostDtoResponse> addPost(@RequestBody PostDtoRequest postDtoRequest){
        iPostService.addPost(postDtoRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // * ==============

    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostRequest> savePromo(@RequestBody PromoPostRequest promoPostRequest){
        return new ResponseEntity<>(iPostService.savePromo(promoPostRequest), HttpStatus.OK);
    }

    // * ==============

    @PostMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountResponse> countPromoByUserId(@RequestParam Integer userId){
        return new ResponseEntity<>(iPostService.countPromoByUserId(userId), HttpStatus.OK);
    }

    // * ==============

    @PostMapping("/promo-post/list")
    public ResponseEntity<List<PromoPostListByUserResponse>> findPromoByUserId(@RequestParam Integer userId){
        return new ResponseEntity<>(iPostService.findPromoByUserId(userId), HttpStatus.OK);
    }

    // * ===== [PUT] ===== *

    // * ===== [DELETE] ===== *

}
