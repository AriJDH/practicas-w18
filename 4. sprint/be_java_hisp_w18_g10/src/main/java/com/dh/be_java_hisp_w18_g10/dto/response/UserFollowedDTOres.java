package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedDTOres {
    //TODO: REQUIRE - US 0004 - GET: /users/{userId}/followed/list

    private int user_id;
    private String user_name;
    private List<FollowedDTOres> followed;

}
