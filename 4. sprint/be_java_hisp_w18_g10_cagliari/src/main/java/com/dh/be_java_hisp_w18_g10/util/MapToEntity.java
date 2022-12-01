package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.ProductDTOreq;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;

public class MapToEntity {

    private static ModelMapper mapper;

    private static ModelMapper instance(){
        if (mapper == null){
            mapper = new ModelMapper();
            mapper.getConfiguration()
                    .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
                    .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
        }
        return mapper;
    }
    public static Post map(PostDTOreq postDTOreq){
        Post post = instance().map(postDTOreq, Post.class);
        Product product = map(postDTOreq.getProduct());
        post.setDate(DateHandler.StringToDate(postDTOreq.getDate()));
        post.setProduct(product);
        return post;
    }
    public static Product map(ProductDTOreq productDTO){
        return instance().map(productDTO, Product.class);
    }


}
