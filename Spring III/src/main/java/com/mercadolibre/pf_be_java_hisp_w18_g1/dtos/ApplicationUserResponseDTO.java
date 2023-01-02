package com.mercadolibre.pf_be_java_hisp_w18_g1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUserResponseDTO {
    @JsonProperty("user_id")
    private Long user_id;
    @JsonProperty("user_name")
    private String userName;
    private String token;
}
