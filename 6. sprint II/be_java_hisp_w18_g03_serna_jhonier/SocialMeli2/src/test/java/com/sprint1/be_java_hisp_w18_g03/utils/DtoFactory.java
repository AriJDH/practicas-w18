package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.dto.request.ProductRequestDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;

import java.time.LocalDate;

public class DtoFactory {


    public static ProductRequestDTO createProductRequest(){

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId(1);
        productRequestDTO.setProductName("Producto");
        productRequestDTO.setType("Tipo");
        productRequestDTO.setColor("Color");
        productRequestDTO.setBrand("Marca");
        productRequestDTO.setNotes("Mis notas");

        return productRequestDTO;
    }

    public static RequestPostDTO requestPostDTO(){

        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setUserId(1);
        requestPostDTO.setDate(LocalDate.of(2022,5,24));
        requestPostDTO.setPrice(45525.5);
        requestPostDTO.setCategory(1);
        requestPostDTO.setProduct(createProductRequest());

        return requestPostDTO;
    }

}
