package com.example.socialmeli.controller;

import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.service.IPublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublicationController {

    private final IPublicationService publicationService;

    @PostMapping("/products/post")
    public ResponseEntity<String> post(@RequestBody PublicationRequest publicationRequest){
       if (publicationService.registerPublication(publicationRequest))
       {
           return new ResponseEntity( "Se creo correctamente", HttpStatus.OK);
       }
       return new ResponseEntity( "No se creo la publicacion, porfavor validar y volver a intentar " , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserFollowedPublicationResponse> getUserFollowedPublicationsById(@PathVariable Integer userId , @RequestParam(defaultValue = "") String order){

        UserFollowedPublicationResponse response = publicationService.getUserFollowedPublicationsById(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
