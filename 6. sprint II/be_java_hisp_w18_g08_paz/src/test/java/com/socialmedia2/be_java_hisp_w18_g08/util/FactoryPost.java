package com.socialmedia2.be_java_hisp_w18_g08.util;

import com.socialmedia2.be_java_hisp_w18_g08.dto.PostDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ProductDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ProductDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FactoryPost {

    public static PostDtoReq createPost(){
        ProductDto productDto = createProductDto();
        return new PostDtoReq(5,productDto,1,1000.,formatterDate());
    }

    public static PostDtoReq createFailedPost(){

        ProductDto productDto = createFailedProductDto();
        return new PostDtoReq(5,productDto,1,1000.,formatterDate());
    }

    public static ProductDtoRes createProductResponse(){
        return new ProductDtoRes(1,"Product1","Type1","Brand1","Color1","Notes1");
    }

    public static List<Post> createPostList(){
        Post post1 = new Post(3,7,createProduct(),3,333.33,formatterDate().plusDays(20));
        return List.of(post1);
    }

    public static List<PostDto> createPostDtoList(){
        PostDto post1 = new PostDto(3,7,createProductResponse(),3,333.33,formatterDate().plusDays(20));
        return List.of(post1);
    }

    public static PostDtoRes cretePostRes(Integer id){
        return new PostDtoRes(id,createPostDtoList());
    }

    public static ProductDto createProductDto(){
        return new ProductDto(1,"Silla","Oficina","Reclinable","Negro","Silla para oficina");
    }

    public static ProductDto createFailedProductDto(){
        return new ProductDto(1,"Silla","Oficina","Reclinable","Negro & Azul","Silla para oficina");
    }

    public static LocalDate formatterDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse("12-11-2022", formatter);
    }

    public static Product createProduct(){
        return new Product(1,"Product1","Type1","Brand1","Color1","Notes1");
    }
}
