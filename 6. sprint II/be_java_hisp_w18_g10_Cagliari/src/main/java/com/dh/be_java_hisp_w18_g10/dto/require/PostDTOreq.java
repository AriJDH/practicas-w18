package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDTOreq {
    //US 0005
    @NotNull(message = "El id no puede estar vacio.")
    @Min(value=1, message = "El id debe ser mayor a cero")
    private int user_id;

    @NotEmpty(message = "La fecha no puede estar vacia.")
    private String date;

    @Valid
    private ProductDTOreq product;

    @NotNull(message ="El campo no puede estar vacio.")
    private int category;

    @NotNull(message ="El campo no puede estar vacio.")
    @Max(value=10000000, message = "El precio maximo por producto es de 10 millones.")
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

