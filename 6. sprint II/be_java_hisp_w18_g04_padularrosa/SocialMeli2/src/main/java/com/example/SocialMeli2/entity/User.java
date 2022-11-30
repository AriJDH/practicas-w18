package com.example.SocialMeli2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class User {
    private Integer user_id;
    private String user_name;
}
