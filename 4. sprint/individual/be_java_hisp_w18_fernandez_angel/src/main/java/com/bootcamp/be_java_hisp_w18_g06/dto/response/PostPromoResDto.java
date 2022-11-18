package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostPromoResDto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
