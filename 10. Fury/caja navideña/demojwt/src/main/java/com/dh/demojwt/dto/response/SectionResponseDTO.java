package com.dh.demojwt.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class SectionResponseDTO {

    @JsonProperty("section_code")
    private Integer sectionCode;

    @JsonProperty("warehouse_code")
    private Integer warehouseCode;





}
