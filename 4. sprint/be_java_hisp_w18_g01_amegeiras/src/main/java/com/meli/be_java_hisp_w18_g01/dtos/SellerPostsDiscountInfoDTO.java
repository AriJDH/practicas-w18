package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerPostsDiscountInfoDTO {
    private long user_id;
    private String user_name;
    private List<PostDiscDTO> posts;
}
