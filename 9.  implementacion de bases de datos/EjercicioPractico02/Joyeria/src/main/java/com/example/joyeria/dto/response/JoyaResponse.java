package com.example.joyeria.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoyaResponse {

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

}
