package com.socialmeli.be_java_hisp_w18g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CrudUserDTORequest {
    private Integer user_id;
    private String user_name;
    private String user_type;
}
