package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.UserDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {
  @Autowired
  private IUserRepository iUserRepository;

  @Override
  public ResponseDTO follow(Integer userId, Integer followId) {
    return null;
  }

  @Override
  public FollowerCountDTO followerCount(Integer userId) {
    User user = iUserRepository.findById(userId);

    if (user == null) {
      return null;
    }

    return new FollowerCountDTO(
      user.getUserId(),
      user.getUserName(),
      user.getListFollowers().size()
    );
  }

  @Override
  public FollowersDTO getFollowersList(Integer userId) {
    return null;
  }

  @Override
  public FollowedDTO getFollowedList(Integer userId) {
    User user = iUserRepository.findById(userId);

    if (user == null) {
      return null;
    }

    return new FollowedDTO(
      user.getUserId(),
      user.getUserName(),
      user
        .getListFollowed()
        .stream()
        .map(i -> new UserDTO(i.getUserId(), i.getUserName()))
        .collect(Collectors.toList())
    );
  }

  @Override
  public ResponseDTO unfollow(Integer userId, Integer followId) {
    return null;
  }
}
