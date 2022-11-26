package com.dh.be_java_hisp_w18_g10.dto.response;

import com.dh.be_java_hisp_w18_g10.dto.require.ProductDTOreq;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTOres {

    private int user_id;
    private int post_id;
    private String date;
    private ProductDTOres product;
    private int category;
    private double price;
}
