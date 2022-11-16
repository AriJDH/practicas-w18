package com.sprint1.be_java_hisp_w18_g03.controller;

import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


  @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<?> unfollow(@PathVariable Integer userId,@PathVariable Integer userIdToUnfollow){


    //return new ResponseEntity<>();
    return null;
  }
}
