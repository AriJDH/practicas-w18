package com.dh.demojwt.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SectionRequestDTO { // US0001
    @JsonProperty("section_code")
    private Integer sectionCode;
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;

}
