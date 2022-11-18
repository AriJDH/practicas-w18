package com.example.BE_java_hisp_w18_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostPromoDTOReq {
    private PostDTOReq post;
    private Boolean has_promo;
    private Double discount;
}
