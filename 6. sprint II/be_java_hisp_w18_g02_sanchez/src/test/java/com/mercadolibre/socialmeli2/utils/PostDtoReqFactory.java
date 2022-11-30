package com.mercadolibre.socialmeli2.utils;

import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;

import java.time.LocalDate;

public class PostDtoReqFactory {

    public static PostDtoReq getPostDtoReq(int userId){

        ProductDto productDtoReq = new ProductDto(
                1,
                "Nombre de producto de 40 caracteres abcd",
                "TipoCon15Caract",
                "Marca con 15 cs",
                "ColorCon15Carac",
                "Notas sobre el producto con un total de 80 caracteres y espacios permitidos abcd");

        return new PostDtoReq(userId, LocalDate.now(), productDtoReq, 1, 10000000.000);
    }

    public static PostDtoReq getInvalidPostDtoReqSizeAndValue(){
        ProductDto productDtoReq = new ProductDto(
                0,
                "Nombre de producto de 41 caracteres abcde",
                "TipoCon16Caracte",
                "Marca con 16 crs",
                "ColorCon16Caract",
                "Notas sobre el producto con un total de 81 caracteres y espacios permitidos abcde");

        return new PostDtoReq(0, LocalDate.now(), productDtoReq, 1, 10000001.000);
    }

    public static PostDtoReq getInvalidPostDtoReqNullsAndBlanks(){
        ProductDto productDtoReq = new ProductDto(null,"","","","","");
        return new PostDtoReq(null, null, productDtoReq, null, null);
    }

    public static PostDtoReq getInvalidPostDtoReqOther(){
        ProductDto productDtoReq = new ProductDto(1,
                "Tiene c.esp &!%",
                "Tiene Espacio",
                "C.Esp &&",
                "Tiene espacio",
                "Tiene caracteres especiales &!.");

        return new PostDtoReq(3, LocalDate.now(), productDtoReq, 1, 0.0);
    }
}
