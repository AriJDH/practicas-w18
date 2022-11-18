package com.socialmedia.be_java_hisp_w18_g08_escandon.util;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.ProductDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Product;

public class Converter {
    public static Product convertProductDtoToProduct(ProductDto productDtoReq){
        Product product = new Product(productDtoReq.getProduct_id(),
                productDtoReq.getProduct_name(),
                productDtoReq.getType(),
                productDtoReq.getBrand(),
                productDtoReq.getColor(),
                productDtoReq.getNotes());
        return product;
    }

    public static ProductDto convertProductToProductDto(Product product){
        ProductDto productDto = new ProductDto(product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
        return productDto;
    }
}
