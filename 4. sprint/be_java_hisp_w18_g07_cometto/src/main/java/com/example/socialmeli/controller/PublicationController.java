package com.example.socialmeli.controller;

import com.example.socialmeli.dto.request.PublicationPromotionRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationPromotionCountResponse;
import com.example.socialmeli.dto.response.PublicationPromotionSumResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli.service.IPublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublicationController {

    private final IPublicationService publicationService;

    /**
     * US 0005: URL=/products/post
     * @param publicationRequest    requestbody - json with publication data and product data
     * @return          respose entity -  OK status code if registry was succesful, Bad_Request if registry could not be added
     */
    @PostMapping("/products/post")
    public ResponseEntity<Void> createPublication(@RequestBody PublicationRequest publicationRequest) {

        publicationService.registerPublication(publicationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * US 0006: URL=/products/followed/{userId}/list
     * @param userId    pathvariable - user identification number
     * @param order     pathvariable - publication response order by date: name_asc=ascending; name_desc=descending
     * @return          respose entity - "user followed publication response DTO" & OK status code
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserFollowedPublicationResponse> getUserFollowedPublicationsById(@PathVariable Integer userId, @RequestParam(defaultValue = "") String order) {

        UserFollowedPublicationResponse response = publicationService.getUserFollowedPublicationsById(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<Void> createPublicationPromotion(@RequestBody
                                                               PublicationPromotionRequest publicationPromotionRequest){
        publicationService.registerPublicationPromotion(publicationPromotionRequest);
        System.out.println("Desde el controlador OK");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PublicationPromotionCountResponse> countPublicationPromotionById(@RequestParam("user_id") Integer userId){
        PublicationPromotionCountResponse result = publicationService.countPublicationPromotionById(userId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /**
     * US 012: Devolver el monto total de publicaciones en promocion
     * @param userId
     * @return
     */
    @GetMapping("/products/promo-post/sum")
    public ResponseEntity<PublicationPromotionSumResponse> sumPublicationPromotionById(@RequestParam("user_id") Integer userId){
        PublicationPromotionSumResponse result = publicationService.sumPublicationPromotionById(userId);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
