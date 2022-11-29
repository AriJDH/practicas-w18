package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.Product;
import com.dh.be_java_hisp_w18_g10.entity.User;
import org.modelmapper.ModelMapper;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DTOMapper {
    private static ModelMapper mapper;
    public static ModelMapper getInstance() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static UserPostsDTOres mapToUserPostsDTOres(User user){
        return getInstance().map(user, UserPostsDTOres.class);
    }

    public static UserFollowedListDTOres mapToUserFollowedRes(User user){
        return getInstance().map(user, UserFollowedListDTOres.class);
    }

    public static UserFollowersListDTOres mapToUserFollowersRes(User user) {

        List<UserDTOres> userDTOresList = user.getFollowers().values()
                .stream()
                .map(entity -> new UserDTOres(entity.getUserId(), entity.getUserName()))
                .collect(Collectors.toList());

        UserFollowersListDTOres userFollowersListDTOres = new UserFollowersListDTOres(user.getUserId(), user.getUserName(), userDTOresList);

        return userFollowersListDTOres;
    }

    public static Post mapToPost(PostDTOreq postDTOreq){
        Post post = new Post();
        post.setUserId(postDTOreq.getUser_id());
        post.setDate(DateHandler.StringToDate(postDTOreq.getDate()));
        Product product = getInstance().map(postDTOreq.getProduct(), Product.class);
        product.setProductId(postDTOreq.getProduct().getProduct_id());
        product.setProductName(postDTOreq.getProduct().getProduct_name());
        post.setProduct(product);
        post.setCategory(postDTOreq.getCategory());
        post.setPrice(postDTOreq.getPrice());
        return post;
    }

    public static PostDTOres mapTo(Post post){
        PostDTOres postRes = new PostDTOres();
        postRes.setUser_id(post.getUserId());
        postRes.setPost_id(post.getPost_id());
        //Parse fecha, ya que el DTO la maneja como String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String postDate = post.getDate().format(formatter);
        postRes.setDate(postDate);
        //Fin de parseo y asignacion de fecha
        postRes.setPrice(post.getPrice());
        //Aca tengo que mapear de Product a ProductDTOres
        postRes.setProduct(mapTo(post.getProduct()));
        //Fin mapeo
        postRes.setCategory(post.getCategory());
        return postRes;
    }

    public static ProductDTOres mapTo(Product product){
        ProductDTOres productDTOres = new ProductDTOres();
        productDTOres.setProduct_id(product.getProductId());
        productDTOres.setType(product.getType());
        productDTOres.setProduct_name(product.getProductName());
        productDTOres.setBrand(product.getBrand());
        productDTOres.setColor(product.getColor());
        productDTOres.setNotes(product.getNotes());
        return productDTOres;
    }

    public static PostDTOres mapToPostDTOres(Post post){
        return getInstance().map(post, PostDTOres.class);
    }
}
