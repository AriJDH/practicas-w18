package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserBuyerFactory {

    public static UserBuyer getUserBuyer() {
        ArrayList<UserSeller> followed = new ArrayList<>();
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(1);
        userBuyer.setUser_name("Josep");
        userBuyer.setFollowed(followed);
        return userBuyer;
    }

    public static UserBuyer getUserBuyer5() {
        ArrayList<UserSeller> followed = new ArrayList<>();
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(5);
        userBuyer.setUser_name("Raquel");
        userBuyer.setFollowed(followed);
        return userBuyer;
    }
    public static UserBuyer getUserBuyer1(){
        List<UserSeller> followed = new ArrayList<>();
        UserSeller userSeller1 = new UserSeller();
        userSeller1.setUser_id(4);
        userSeller1.setUser_name("Oliver");
        UserSeller userSeller2 = new UserSeller();
        userSeller2.setUser_id(2);
        userSeller2.setUser_name("Ethan");
        UserSeller userSeller3 = new UserSeller();
        userSeller3.setUser_id(3);
        userSeller3.setUser_name("Kyle");
        followed.add(userSeller1);
        followed.add(userSeller2);
        followed.add(userSeller3);

        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUser_id(1);
        userBuyer.setUser_name("Josep");
        userBuyer.setFollowed(followed);
        return userBuyer;
    }

}
