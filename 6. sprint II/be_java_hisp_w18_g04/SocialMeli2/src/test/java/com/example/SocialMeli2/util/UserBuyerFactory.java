package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserBuyerFactory {

    public static UserBuyer getUserBuyer(){
        ArrayList<UserSeller> followed = new ArrayList<>();
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(1);
        userBuyer.setUser_name("Josep");
        userBuyer.setFollowed(followed);
        return userBuyer;
    }
    public static List<UserBuyer> getUserBuyerList(){
        List<UserBuyer> userBuyerList = new ArrayList<>();
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(1);
        userBuyer.setUser_name("James");
        userBuyer.setFollowed(new ArrayList<>());
        userBuyerList.add(userBuyer);
        return userBuyerList;
    }


}
