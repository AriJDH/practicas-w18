package com.socialmedia.be_java_hisp_w18_g08.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia.be_java_hisp_w18_g08.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostPromoDtoRes {

    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;


}
