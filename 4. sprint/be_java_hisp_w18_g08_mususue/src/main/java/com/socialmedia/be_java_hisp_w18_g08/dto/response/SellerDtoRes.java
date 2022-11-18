package com.socialmedia.be_java_hisp_w18_g08.dto.response;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellerDtoRes {
    private Integer user_id;
    private String user_name;
    private List<Post> posts;
}
