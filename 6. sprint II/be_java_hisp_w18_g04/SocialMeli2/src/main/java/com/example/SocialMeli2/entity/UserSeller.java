package com.example.SocialMeli2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSeller extends User {
    private List<UserBuyer> followers;
    private List<Post> posts;
}
