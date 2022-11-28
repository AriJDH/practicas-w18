package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;

import java.util.Arrays;

public class UserGenerator {

    public static User getUser(int id, String name){
        User newUser = new User(id, name);
        return newUser;
    }
    public static User getUserWithFollowers(){
        User newUser = new User(1, "Followed");
        newUser.getFollowers().put(2, getUser(2, "userC"));
        newUser.getFollowers().put(3, getUser(3, "userB"));
        return newUser;
    }

    public static UserFollowersListDTOres UserFollowersDTOGenerator(){
        UserFollowersListDTOres userFollowersListDTOres = new UserFollowersListDTOres();
        userFollowersListDTOres.setUser_name("Followed");
        userFollowersListDTOres.setUser_id(1);
        UserDTOres follower1 = new UserDTOres(2, "userC");
        UserDTOres follower2 = new UserDTOres(3, "userB");
        userFollowersListDTOres.setFollowers(Arrays.asList(follower1, follower2));
        return userFollowersListDTOres;
    }
}
