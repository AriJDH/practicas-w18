package com.socialmedia2.be_java_hisp_w18_g08.controller;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.*;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.service.IUserService;
import com.socialmedia2.be_java_hisp_w18_g08.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private IUserService userService;

    public UserController(UserServiceImp service) {
        this.userService = service;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDtoRes> follow(@PathVariable
                                               @NotBlank(message = "El  id no puede estar vacío.")
                                               @Min(value = 0, message = "El id debe ser mayor a cero")
                                               Integer userId,
                                               @PathVariable Integer userIdToFollow) {
        FollowDtoReq followDtoReq = new FollowDtoReq(userId, userIdToFollow);
        return new ResponseEntity<>(userService.follow(followDtoReq), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDto> getFollowed(@PathVariable
                                                   @NotBlank(message = "El  id no puede estar vacío.")
                                                   @Min(value = 0, message = "El id debe ser mayor a cero")
                                                   Integer userId,
                                                   @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDto> findAllFollowersQuantity(@PathVariable
                                                                            @NotBlank(message = "El  id no puede estar vacío.")
                                                                            @Min(value = 0, message = "El id debe ser mayor a cero")
                                                                            Integer userId){
        return new ResponseEntity<>(userService.findAllFollowersQuantity(userId), HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserListDto> findUserListBySeller(@PathVariable
                                                            @NotBlank(message = "El  id no puede estar vacío.")
                                                            @Min(value = 0, message = "El id debe ser mayor a cero")
                                                            Integer userId,
                                                            @RequestParam(required = false) String order) {
        UserListDto userListDTO = userService.findUserListBySeller(userId, order);
        return ResponseEntity.ok().body(userListDTO);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseMessasgeDto> unFollow(@PathVariable
                                                        @NotBlank(message = "El  id no puede estar vacío.")
                                                        @Min(value = 0, message = "El id debe ser mayor a cero")
                                                        Integer userId, @PathVariable Integer userIdToUnfollow){
        ResponseMessasgeDto response = new ResponseMessasgeDto(userService.unFollow(userId,userIdToUnfollow),200, LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}