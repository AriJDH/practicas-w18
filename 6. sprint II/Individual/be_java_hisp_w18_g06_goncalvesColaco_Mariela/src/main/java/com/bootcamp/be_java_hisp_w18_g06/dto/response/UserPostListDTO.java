package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserPostListDTO {
    //US-006
    @JsonProperty("user_id")
    private Integer userId;
    List<PostResDto> postDTOList = new ArrayList<>();
}
