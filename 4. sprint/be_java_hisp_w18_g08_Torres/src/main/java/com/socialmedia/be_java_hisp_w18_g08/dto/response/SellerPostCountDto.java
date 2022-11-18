package com.socialmedia.be_java_hisp_w18_g08.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerPostCountDto {
    private String user_id;
    private String user_name;
    private Integer promo_products_count;

    public SellerPostCountDto(Integer user_id, String user_name, int quantity) {
    }
}
