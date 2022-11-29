package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.User;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserSellerFactory {
    public static UserSeller getUserSeller(){
        ArrayList<UserBuyer> followers = new ArrayList<>();
        UserSeller userSeller = new UserSeller();
        userSeller.setUser_id(1);
        userSeller.setUser_name("James");
        userSeller.setFollowers(followers);
        userSeller.setPosts(PostFactory.getPostList());
        return userSeller;
    }

    public static List<UserSeller> getUserSellerList(){
        List<UserSeller> userSellerList = new ArrayList<>();
        UserSeller userSeller = new UserSeller();
        userSeller.setUser_id(3);
        userSeller.setUser_name("Kyle");
        userSeller.setFollowers(new ArrayList<>());
        userSeller.setPosts(PostFactory.getPostList());
        userSellerList.add(userSeller);
        return userSellerList;
    }
}
