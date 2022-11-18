package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersCountDTOres {
    //TODO US 0002 - GET - /users/{userId}/followers/count
    private int user_id;
    private String user_name;
    private int followers_count;

}

// JSON REPRESENTATION
// {
//  "user_id": 0,
//  "user_name": "",
//  "followers_count": 0
//}
