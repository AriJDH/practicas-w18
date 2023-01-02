package com.example.frescos.dtos.response;

import com.example.frescos.enums.SectionCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedSectionsResponseDTO {
    @JsonProperty("sections")
    private List<SectionCode> sectionCodes;
}
