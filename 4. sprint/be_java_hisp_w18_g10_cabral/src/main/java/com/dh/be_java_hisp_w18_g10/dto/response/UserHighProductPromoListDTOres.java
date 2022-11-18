package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserHighProductPromoListDTOres {
    // US 00012 - GET: /products/promo-post/highPromoList
    private int user_id;
    private String user_name;
    private List<PostPromoDTOres> posts;
}
