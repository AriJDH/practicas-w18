package com.socialmedia2.be_java_hisp_w18_g08.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ProductDtoRes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer post_id;
    private Integer user_id;
    private ProductDtoRes product;
    private Integer category;
    private Double price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
