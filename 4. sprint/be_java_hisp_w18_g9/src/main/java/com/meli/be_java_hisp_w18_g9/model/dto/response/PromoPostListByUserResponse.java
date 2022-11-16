package com.meli.be_java_hisp_w18_g9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PromoPostRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostListByUserResponse {

    // ? =============== Attributes =============== ?

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    private UserSimpleResponse user;

    private List<PromoPostRequest> posts;
}
