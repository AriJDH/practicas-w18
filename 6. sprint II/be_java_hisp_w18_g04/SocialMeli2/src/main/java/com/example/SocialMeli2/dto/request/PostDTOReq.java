package com.example.SocialMeli2.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTOReq {
    @NotEmpty (message = "The user id cannot be empty")
    @Positive (message = "The user id must be greater than 0")
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotEmpty (message = "The date cannot be empty")
    private LocalDate date;
    @Valid
    private ProductDTOReq product;
    @NotEmpty (message = "The category cannot be empty")
    private Integer category;
    @NotEmpty (message = "The price cannot be empty")
    @Positive (message = "The price per product must be greater than 0")
    @Max(value= 10000000,message = "The maximum price per product is 10.000.000")
    private Double price;
}
