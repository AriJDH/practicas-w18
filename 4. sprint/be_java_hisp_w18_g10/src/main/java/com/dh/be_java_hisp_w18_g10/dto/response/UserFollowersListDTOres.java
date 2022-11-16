package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersListDTOres {
    //TODO: REQUIRE - US 0003 - GET: /users/{userId}/followers/list
    // US 0008

    private int user_id;
    private String user_name;
    private List<UserDTOres> followers;

}

// JSON REPRESENTATION
// {
//  "user_id": 0,
//  "user_name": "",
//  "followers": [
//    {
//      "user_id": 0,
//      "user_name": ""
//    }
//  ]
//}