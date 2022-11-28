package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.util.ArrayList;

public class UserFactor {

    public static User getUser(Integer id, String name){
        return new User(id, name, new ArrayList<>(), new ArrayList<>());
    }
}
