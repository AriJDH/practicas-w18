package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPostListDTO {
    //US-006
    private Integer user_id;
    List<PostResDto> postDTOList;
}
