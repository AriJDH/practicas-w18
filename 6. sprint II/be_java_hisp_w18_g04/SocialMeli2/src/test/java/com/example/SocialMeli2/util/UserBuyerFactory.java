package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.UserBuyer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserBuyerFactory {

    public static UserBuyer getUserBuyer(){
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(3);
        userBuyer.setUser_name("Louis");
        userBuyer.setFollowed(Collections.emptyList());
        return userBuyer;
    }
    public static List<UserBuyer> getUserBuyerList(){
        List<UserBuyer> userBuyerList = new ArrayList<>();
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(3);
        userBuyer.setUser_name("Louis");
        userBuyer.setFollowed(Collections.emptyList());
        userBuyerList.add(userBuyer);
        return userBuyerList;
    }


}
