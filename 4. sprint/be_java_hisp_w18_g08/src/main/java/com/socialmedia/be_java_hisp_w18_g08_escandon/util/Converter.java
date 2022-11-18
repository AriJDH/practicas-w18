package com.socialmedia.be_java_hisp_w18_g08_escandon.util;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.ProductDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Product;

public class Converter {
    public static Product convertProductDtoToProduct(ProductDtoReq productDtoReq){
        Product product = new Product(productDtoReq.getProduct_id(),
                productDtoReq.getProduct_name(),
                productDtoReq.getType(),
                productDtoReq.getBrand(),
                productDtoReq.getColor(),
                productDtoReq.getNotes());
        return product;
    }
}
