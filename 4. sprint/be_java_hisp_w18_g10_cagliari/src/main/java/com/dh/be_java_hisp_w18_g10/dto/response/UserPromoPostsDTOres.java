package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromoPostsDTOres {

    private String user_id;
    private String user_name;
    private List<PostPromoDTOres> posts;

}

// JSON REPRESENTATION
//{
//  "user_id": "",
//  "user_name": "",
//  "posts": [
//    {
//      "user_id": 0,
//      "post_id": 0,
//      "date": "",
//      "product": {
//        "product_id": 0,
//        "product_name": "",
//        "type": "",
//        "brand": "",
//        "color": "",
//        "notes": ""
//      },
//      "category": 0,
//      "price": 0.0,
//      "has_promo": false,
//      "discount": 0.0
//    }
//  ]
//}