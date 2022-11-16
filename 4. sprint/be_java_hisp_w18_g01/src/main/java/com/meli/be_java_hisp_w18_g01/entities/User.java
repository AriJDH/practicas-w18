package com.meli.be_java_hisp_w18_g01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;

}
