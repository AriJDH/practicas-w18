package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class UserPostListDTO {
    //US-006
    private int user_id;
    List<PostResDto> postDTOList;
}
