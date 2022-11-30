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

    public static UserSeller getUserSeller4(){
        ArrayList<UserBuyer> followers = new ArrayList<>();
        UserSeller userSeller = new UserSeller();
        userSeller.setUser_id(4);
        userSeller.setUser_name("Oliver");
        userSeller.setFollowers(followers);
        userSeller.setPosts(PostFactory.getPostListTwoWeeksBySeller4());
        return userSeller;
    }
    public static UserSeller getUserSeller2(){
        List<UserBuyer> followers = new ArrayList<>();
        UserBuyer userBuyer1 = new UserBuyer();
        userBuyer1.setUser_id(1);
        userBuyer1.setUser_name("Josep");
        UserBuyer userBuyer2 = new UserBuyer();
        userBuyer2.setUser_id(3);
        userBuyer2.setUser_name("Louis");
        UserBuyer userBuyer3 = new UserBuyer();
        userBuyer3.setUser_id(4);
        userBuyer3.setUser_name("Kevin");
        followers.add(userBuyer1);
        followers.add(userBuyer2);
        followers.add(userBuyer3);
        UserSeller userSeller = new UserSeller();
        userSeller.setUser_id(2);
        userSeller.setUser_name("Ethan");
        userSeller.setFollowers(followers);
        userSeller.setPosts(new ArrayList<>());
        return userSeller;
    }


}
