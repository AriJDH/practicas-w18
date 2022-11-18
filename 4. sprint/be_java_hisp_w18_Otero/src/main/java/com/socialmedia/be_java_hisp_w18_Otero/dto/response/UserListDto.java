package com.socialmedia.be_java_hisp_w18_Otero.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserListDto {

    private Integer user_id;
    private String user_name;
    private List<UserDto> followers;

}
