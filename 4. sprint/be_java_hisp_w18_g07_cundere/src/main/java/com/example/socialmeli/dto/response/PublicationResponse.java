package com.example.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationResponse {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Integer userId;
    @JsonProperty("product")
    private ProductResponse productResponse;
    private Integer category;
    private Double price;

}
