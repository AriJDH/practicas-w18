package com.socialmeli.be_java_hisp_w18g05.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Seller extends User {

    private List<Buyer> followers;
    private List<Post> posts;


}
