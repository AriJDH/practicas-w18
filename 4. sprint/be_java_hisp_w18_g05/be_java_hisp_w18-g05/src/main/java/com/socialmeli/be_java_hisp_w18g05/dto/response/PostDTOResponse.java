package com.socialmeli.be_java_hisp_w18g05.dto.response;

import com.socialmeli.be_java_hisp_w18g05.dto.request.ProductDTORequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDTOResponse {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDTOResponse product;
    private Integer category;
    private Double price;
}
