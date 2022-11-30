package com.meli.be_java_hisp_w18_g9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostListByFollowedResponse {

    // ? =============== Attributes =============== ?

    @JsonProperty("user_id")
    @NotNull(message = "The user_id field cannot be null")
    @Positive(message = "The user_id field must be greater than zero")
    private Integer userId;

    private List<@Valid PostDtoRequest> posts;

}
