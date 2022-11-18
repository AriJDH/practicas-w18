package com.example.BE_java_hisp_w18_g04.entity;

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
