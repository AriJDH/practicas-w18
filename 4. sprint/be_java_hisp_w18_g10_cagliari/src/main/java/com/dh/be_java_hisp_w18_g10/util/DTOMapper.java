package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.ProductDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.Product;
import com.dh.be_java_hisp_w18_g10.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;

import java.util.List;
import java.util.stream.Collectors;

public class DTOMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private static void mapperConfigUnderToCamel(){
        modelMapper.getConfiguration()
                .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
                .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
    }

    private static void mapperConfigCamelToUnder(){
        modelMapper.getConfiguration()
                .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);
    }

    public static UserPostsDTOres mapToUserPostsDTOres(User user){
        return modelMapper.map(user, UserPostsDTOres.class);
    }

    public static UserFollowedListDTOres mapToUserFollowedRes(User user){
        return modelMapper.map(user, UserFollowedListDTOres.class);
    }

    public static UserFollowersListDTOres mapTo(User user, List<User> userFollowers) {

        List<UserDTOres> userDTOresList = userFollowers
                .stream()
                .map(entity -> new UserDTOres(entity.getUserId(), entity.getUserName()))
                .collect(Collectors.toList());

        return new UserFollowersListDTOres(user.getUserId(), user.getUserName(), userDTOresList);
    }

    public static Post mapTo(PostDTOreq postDTOreq){
        mapperConfigUnderToCamel();
        Post post = modelMapper.map(postDTOreq, Post.class);
        Product product = mapTo(postDTOreq.getProduct());
        post.setDate(DateHandler.StringToDate(postDTOreq.getDate()));
        post.setProduct(product);
        return post;
    }

    public static Product mapTo(ProductDTOreq productDTO){
        mapperConfigUnderToCamel();
        return modelMapper.map(productDTO, Product.class);
    }

    public static PostDTOres mapTo(Post post){
        mapperConfigCamelToUnder();
        PostDTOres postDTO = modelMapper.map(post, PostDTOres.class);
        ProductDTOres productDTO = mapTo(post.getProduct());
        postDTO.setProduct(productDTO);
        postDTO.setDate(DateHandler.DateToString(post.getDate()));
        return postDTO;
    }

    public static ProductDTOres mapTo(Product product){
        mapperConfigCamelToUnder();
        return modelMapper.map(product, ProductDTOres.class);
    }

    public static PostDTOres mapToPostDTOres(Post post){
        return modelMapper.map(post, PostDTOres.class);
    }

    public static UserPromoPostCountDTOres mapTo(User user, int promoCount){
        UserPromoPostCountDTOres userPromoDTO = modelMapper.map(user, UserPromoPostCountDTOres.class);
        userPromoDTO.setPromo_products_count(promoCount);
        return userPromoDTO;
    }
}
