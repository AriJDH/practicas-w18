package com.socialmedia.be_java_hisp_w18_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerFollowersCountDTO{

    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}
