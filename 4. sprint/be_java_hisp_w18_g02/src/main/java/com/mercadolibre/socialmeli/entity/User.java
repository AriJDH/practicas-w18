package com.mercadolibre.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private List<Post> posts;
    private Set<User> followed;

    public User(Integer id, String name){
        this.id = id;
        this.name = name;
        this.posts = new ArrayList<Post>();
        this.followed = new HashSet<User>();
    }

    public void addPost(Post p){
        this.posts.add(p);
    }

    public boolean addFollowed(User u){
        return this.followed.add(u);
    }

    public boolean isSeller(){
        return (this.posts!=null && !this.posts.isEmpty());
    }

}
