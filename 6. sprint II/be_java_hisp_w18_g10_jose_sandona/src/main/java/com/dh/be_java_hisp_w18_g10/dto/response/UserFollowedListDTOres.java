package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedListDTOres {
    //TODO: REQUIRE - US 0004 - GET: /users/{userId}/followed/list
    // US 0008
    private int user_id;
    private String user_name;
    private List<UserDTOres> followed;

}

// JSON REPRESENTATION:
// {
//  "user_id": 0,
//  "user_name": "",
//  "followed": [
//    {
//      "user_id": 0,
//      "user_name": ""
//    }
//  ]
//}
