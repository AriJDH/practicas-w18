package com.example.socialmeli.controller;

import com.example.socialmeli.dto.request.PostProductPromRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.UserPostPromoCountResponse;
import com.example.socialmeli.service.interfaces.IPublicationPromService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PromoProductsController {
    private final IPublicationPromService publicationPromService;

    /**
     * US 0005: URL=/products/post
     * @param publicationRequest    requestbody - json with publication data and product data
     * @return          respose entity -  OK status code if registry was succesful, Bad_Request if registry could not be added
     */
    @PostMapping("/products/promo-post")
    public ResponseEntity<Void> createPublication(@RequestBody PostProductPromRequest publicationRequest) {
        publicationPromService.registerPublicationProm(publicationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<UserPostPromoCountResponse> getUserPromProductCount(@RequestParam("user_id") Integer userId) {
        return new ResponseEntity<>(publicationPromService.getUserPromProductCount(userId), HttpStatus.OK);
    }
}
