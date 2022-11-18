package com.sprint1.be_java_hisp_w18_g03_serna.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private List<User> listFollowed;
    private List<User> listFollowers;
}
