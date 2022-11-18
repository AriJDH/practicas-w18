package com.example.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequest {
    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Integer userId;
    private Integer productId;
    private Integer category;
    private Double price;

}
