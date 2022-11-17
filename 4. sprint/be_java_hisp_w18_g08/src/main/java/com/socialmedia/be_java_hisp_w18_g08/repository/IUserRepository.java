package com.socialmedia.be_java_hisp_w18_g08.repository;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoReq;
import java.util.Optional;
import java.util.List;

public interface IUserRepository {

    List<String> follow (Integer userId, Integer userIdToFollow);
    User getUserByID(Integer userId);
}
