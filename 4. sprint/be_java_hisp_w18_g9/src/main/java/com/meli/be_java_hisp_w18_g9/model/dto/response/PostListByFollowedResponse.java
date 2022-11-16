package com.meli.be_java_hisp_w18_g9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostListByFollowedResponse {

    // ? =============== Attributes =============== ?

    @JsonProperty("user_id")
    private Integer userId;

    private List<PostDtoRequest> posts;

}
