package com.sprint1.be_java_hisp_w18_g03.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UsersDTO {

    private List<UserDTO> users;

}
