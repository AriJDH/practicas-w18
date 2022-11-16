package com.sprint1.be_java_hisp_w18_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestPostDTO {
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductRequestDTO product;
    private Integer category;
    private Double price;
}
