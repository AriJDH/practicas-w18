package com.sprint1.be_java_hisp_w18_g03.controller;

import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private IUserService userService;

  @GetMapping("/{userId}/followers/count")
  public ResponseEntity<FollowerCountDTO> followerCount(
    @PathVariable Integer userId
  ) {
    var user = userService.followerCount(userId);
    if (user == null) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(user, HttpStatus.OK);
  }
    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.ACCEPTED);
    }
  @GetMapping("/{userId}/followed/list")
  public ResponseEntity<FollowedDTO> getFollowedList(
    @PathVariable Integer userId
  ) {
    var user = userService.getFollowedList(userId);
    if (user == null) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(user, HttpStatus.OK);
  }
  @GetMapping( "/{userId}/followers/list")
  public ResponseEntity<FollowersDTO> getListFollowers(@PathVariable Integer userId){
    return new ResponseEntity<>(userService.getFollowersList(userId), HttpStatus.OK);
  }
}
