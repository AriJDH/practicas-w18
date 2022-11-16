package com.meli.be_java_hisp_w18_g01.services;

public interface UserService {
    void handleFollow(long userId, long userIdToFollow);
    void handleUnfollow(long userId, long userIdToUnfollow);
}
