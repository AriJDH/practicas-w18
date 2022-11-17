package com.dh.be_java_hisp_w18_g10.dto.require;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDTOreq {
    //US 0005
    private int user_id;

    private String date;

    private ProductDTOreq product;
    private int category;
    private double price;
}

//JSON REPRESENTATION
// {
//  "user_id": 0,
//  "date": "",
//  "product": {
//    "product_id": 0,
//    "product_name": "",
//    "type": "",
//    "brand": "",
//    "color": "",
//    "notes": ""
//  },
//  "category": 0,
//  "price": 0.0
//}

