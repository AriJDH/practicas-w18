package com.socialmedia.be_java_hisp_w18_Otero.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer user_id;
    private String user_name;
    private List<Seller> followed;

}
