package com.socialmedia2.be_java_hisp_w18_g08.util;

import com.socialmedia2.be_java_hisp_w18_g08.dto.ProductDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ProductDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;

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

    public static ProductDtoRes convertProductToProductDtoRes(Product product){
        ProductDtoRes productDto = new ProductDtoRes(product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
        return productDto;
    }

}
