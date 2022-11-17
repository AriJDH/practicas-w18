package com.socialmedia.be_java_hisp_w18_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FollowedDTO {

    private Integer user_id;
    private String user_name;
    private List<UserDTO> followed;

}
