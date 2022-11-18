package com.sprint1.be_java_hisp_w18_g03.dto.request;

import com.sprint1.be_java_hisp_w18_g03.dto.response.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsersDTO {

    private List<UserDTO> users;

}
