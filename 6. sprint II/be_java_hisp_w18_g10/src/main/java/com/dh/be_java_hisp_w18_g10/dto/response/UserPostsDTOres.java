package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostsDTOres {
    // US 0006 - GET - /products/followed/{userId}/list
    // US 0009
    private int user_id;
    private List<PostDTOres> posts;
}

// JSON REPRESENTATION
// {
//  "user_id": 0,
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
//      "price": 0.0
//    }
//  ]
//}