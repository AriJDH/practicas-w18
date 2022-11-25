package com.socialmeli.be_java_hisp_w18g05.dto.response;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerFollowersCountDTOResponse {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}
