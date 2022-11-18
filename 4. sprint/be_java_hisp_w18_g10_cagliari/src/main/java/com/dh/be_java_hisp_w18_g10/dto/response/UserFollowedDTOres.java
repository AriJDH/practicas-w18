package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedDTOres {
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
