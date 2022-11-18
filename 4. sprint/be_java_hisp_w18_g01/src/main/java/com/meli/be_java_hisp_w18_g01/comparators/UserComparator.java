package com.meli.be_java_hisp_w18_g01.comparators;

import com.meli.be_java_hisp_w18_g01.entities.User;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        int followersCountComparation = u1.getFollowersCount()-u2.getFollowersCount();
        int postsCountCompararion = u1.getPostsCount()-u2.getPostsCount();
        return followersCountComparation==0? postsCountCompararion:followersCountComparation;
    }
}
