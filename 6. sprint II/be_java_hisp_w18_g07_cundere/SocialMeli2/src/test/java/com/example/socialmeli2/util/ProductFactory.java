package com.example.socialmeli2.util;

import com.example.socialmeli2.dto.request.ProductRequest;

public class ProductFactory {

    public static ProductRequest getProductRequestWithInvalidFields() {

        ProductRequest request = new ProductRequest();
        request.setId(0);
        request.setName("$test$");
        request.setType("");
        request.setBrand("Logisech");
        request.setColor("unColorQueSupereLaCantidadMaximaLongitud");
        request.setNotes("$%%$");

        return request;

    }

    public static ProductRequest getProductRequestWithValidFields() {

        ProductRequest request = new ProductRequest();
        request.setId(1);
        request.setName("test");
        request.setType("Some type test");
        request.setBrand("Logisech");
        request.setColor("Orange");
        request.setNotes("this is a test note");

        return request;

    }

}
