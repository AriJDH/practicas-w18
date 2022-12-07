package com.jewels.jewels.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jewels.jewels.model.Jewel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class JewelsResponseDTO {

    private String message;

    private List<Jewel> jewels;
}
