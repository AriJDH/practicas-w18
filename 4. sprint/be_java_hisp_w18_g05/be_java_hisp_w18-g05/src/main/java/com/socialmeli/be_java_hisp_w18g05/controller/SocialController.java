package com.socialmeli.be_java_hisp_w18g05.controller;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.service.IService;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class SocialController {
    private IService service;

    public SocialController(ServiceImp service) {
        this.service = service;
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersListDTOResponse> followersList(@PathVariable Integer userId){
        return new ResponseEntity<>(service.getFollowers(userId), HttpStatus.OK);
    }

}
