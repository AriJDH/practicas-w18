package com.example.socialmeli2.util;

import com.example.socialmeli2.dto.request.ProductRequest;

public class ProductDtoFactory {
    public static ProductRequest getProductRequest(){
       ProductRequest productRequest= new ProductRequest();
       productRequest.setId(1);
       productRequest.setName("Silla");
       productRequest.setType("Gamer");
       productRequest.setBrand("Racer");
       productRequest.setColor("Color");
       productRequest.setNotes("Sinsdsdsdf");
       return productRequest;
    }
}
