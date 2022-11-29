package com.socialmeli.be_java_hisp_w18g05.entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Buyer extends User {

    private List<Seller> followeds;

    public Buyer(Integer user_id, String name) {
        super(user_id, name);
        this.followeds = new ArrayList<>();
    }

    public Buyer(Integer user_id, String name, List<Seller> followeds) {
        super(user_id, name);
        this.followeds = followeds;
    }

    public void addFollowed(Seller seller){
        followeds.add(seller);
    }

    public void unFollowed(Seller seller){
        followeds.remove(seller);
    }
}

