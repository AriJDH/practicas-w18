package com.socialmedia.be_java_hisp_w18_g08.entity;

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
}
