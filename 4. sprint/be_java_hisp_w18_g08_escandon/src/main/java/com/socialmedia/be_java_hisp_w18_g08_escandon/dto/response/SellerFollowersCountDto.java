package com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerFollowersCountDto {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}
