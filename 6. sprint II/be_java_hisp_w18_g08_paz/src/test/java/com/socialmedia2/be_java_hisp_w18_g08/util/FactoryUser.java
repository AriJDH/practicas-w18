package com.socialmedia2.be_java_hisp_w18_g08.util;

import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;

import java.util.ArrayList;


public class FactoryUser {

    public static Seller createSeller(){
        return new Seller(1, "Seller1", new ArrayList<>(), FactoryPost.createPostList(), new ArrayList<>());
    }

    public static User createUser(){
        return new User(2,"User2", new ArrayList<>());
    }
}
