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
    private Integer user_id;
    private String user_name;
    @JsonIgnore
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;
    
    public User(Integer user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public User(Integer id) {
        this.user_id = user_id;
    }
}
