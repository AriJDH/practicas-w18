package com.bootcamp.be_java_hisp_w18_g06.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class User {
    private int user_id;
    private String user_name;
    @JsonIgnore
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;
    private List<PromoPost> promotions;
    
    public User(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
