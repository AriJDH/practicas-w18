package com.socialmeli.be_java_hisp_w18g05.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class PostDTOResponse {


    private Integer user_id;
    private Integer post_id;
    private String date;
    private ProductDTOResponse product;
    private Integer category;
    private Double price;
}
