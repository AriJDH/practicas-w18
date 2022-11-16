package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersDTOres {

    private int user_id;
    private String user_name;
    private int followers_count;


}
