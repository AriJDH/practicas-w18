package com.sprint1.be_java_hisp_w18_g03.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FollowedDTO {
    private Integer userId;
    private String userName;
    private List<UserDTO> followed;
}
