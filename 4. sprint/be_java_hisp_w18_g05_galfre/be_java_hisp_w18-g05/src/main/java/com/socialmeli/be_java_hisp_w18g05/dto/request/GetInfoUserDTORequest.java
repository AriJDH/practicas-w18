package com.socialmeli.be_java_hisp_w18g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetInfoUserDTORequest {
    private Integer user_id;
    private String user_name;
}
