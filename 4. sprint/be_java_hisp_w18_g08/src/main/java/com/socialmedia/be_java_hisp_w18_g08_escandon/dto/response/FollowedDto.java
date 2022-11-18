package com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FollowedDto {

    private Integer user_id;
    private String user_name;
    private List<UserDto> followed;

}
