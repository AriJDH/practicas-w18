package com.socialmeli.be_java_hisp_w18g05.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Seller extends User {

    private List<Buyer> followers = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public Seller(Integer user_id, String name) {
        super(user_id, name);
    }

    public Seller(Integer user_id, String name, List<Buyer> followers) {
        super(user_id, name);
        this.followers = followers;
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void addFollower(Buyer buyer){
        followers.add(buyer);
    }
    public void unFollower(Buyer buyer){
        followers.remove(buyer);
    }
}
