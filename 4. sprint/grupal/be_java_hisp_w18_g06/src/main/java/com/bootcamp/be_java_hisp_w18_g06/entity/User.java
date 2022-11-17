package com.bootcamp.be_java_hisp_w18_g06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;
    
    public User(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
