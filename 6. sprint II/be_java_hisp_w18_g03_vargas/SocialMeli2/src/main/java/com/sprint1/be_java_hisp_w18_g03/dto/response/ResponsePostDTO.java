package com.sprint1.be_java_hisp_w18_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ResponsePostDTO {
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private ProductResponseDTO product;
    private Integer category;
    private Double price;
    @JsonProperty("post_id")
    private Integer postId;
}
