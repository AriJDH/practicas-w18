package com.socialmeli.be_java_hisp_w18g05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public abstract class User {

    private Integer user_id;
    private String name;
}
