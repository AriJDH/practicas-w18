package com.socialmeli.be_java_hisp_w18g05.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewPostDTORequest {
    private Integer user_id;
    //@JsonFormat(pattern = "dd-MM-yyyy")
    private String date;
    private ProductDTORequest product;
    private Integer category;
    private Double price;
}
