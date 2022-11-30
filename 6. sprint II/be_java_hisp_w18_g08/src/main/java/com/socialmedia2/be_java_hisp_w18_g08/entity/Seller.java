package com.socialmedia2.be_java_hisp_w18_g08.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seller extends User{
    private List<Post> posts;
    private List<User> followers;

    public Seller(Integer user_id, String user_name, List<Seller> followed, List<Post> posts, List<User> followers) {
        super(user_id, user_name, followed);
        this.posts = posts;
        this.followers = followers;
    }
}
