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

public class MapToDto {

    private static ModelMapper mapper;

    private static ModelMapper instance(){
        if (mapper == null){
            mapper = new ModelMapper();
            mapper.getConfiguration()
                    .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                    .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);
        }
        return mapper;
    }

    public static UserPostsDTOres map(User user, List<Post> posts){
        UserPostsDTOres userPostsDTO = instance().map(user, UserPostsDTOres.class);

        List<PostDTOres> postsDTO = posts
                .stream()
                .map(DTOMapper::mapTo)
                .collect(Collectors.toList());

        userPostsDTO.setPosts(postsDTO);

        return userPostsDTO;
    }

    public static UserFollowedDTOres map(User user, List<User> userFollowers){
        UserFollowedDTOres userFollowedDTO = instance().map(user, UserFollowedDTOres.class);
        List<UserDTOres> usersDTO = userFollowers
                .stream()
                .map(DTOMapper::mapTo)
                .collect(Collectors.toList());
        userFollowedDTO.setFollowed(usersDTO);
        return userFollowedDTO;
    }

    public static UserFollowersDTOres map(User user, List<User> userFollowers) {
        List<UserDTOres> userDTOresList = userFollowers
                .stream()
                .map(entity -> new UserDTOres(entity.getUserId(), entity.getUserName()))
                .collect(Collectors.toList());
        return new UserFollowersDTOres(user.getUserId(), user.getUserName(), userDTOresList);
    }

    public static ProductDTOres map(Product product){
        return instance().map(product, ProductDTOres.class);
    }

    public static PostDTOres map(Post post){
        return instance().map(post, PostDTOres.class);
    }

    public static UserPromoPostCountDTOres map(User user, int promoCount){
        UserPromoPostCountDTOres userPromoDTO = instance().map(user, UserPromoPostCountDTOres.class);
        userPromoDTO.setPromo_products_count(promoCount);
        return userPromoDTO;
    }

    public static UserPromoPostsDTOres map(User user, List<Post> promoPost){
        UserPromoPostsDTOres userPromoDTO = instance().map(user, UserPromoPostsDTOres.class);
        List<PostPromoDTOres> postsPromoDTO = promoPost
                .stream()
                .map(MapToDto::map)
                .collect(Collectors.toList());
        userPromoDTO.setPosts(postsPromoDTO);
        return userPromoDTO;
    }

    public static PostPromoDTOres map(Post post){
        return instance().map(post, PostPromoDTOres.class);
    }

    public static UserFollowedDTOres map(User user, List<User> userFollowed){
        UserFollowedDTOres usersFollowedList = instance().map(user, UserFollowedDTOres.class);
        List<UserDTOres> userDTOres = userFollowed
                .stream()
                .map(DTOMapper::mapTo)
                .collect(Collectors.toList());
        usersFollowedList.setFollowed(userDTOres);
        return usersFollowedList;
    }

    public static UserDTOres mapTo(User user){
        return instance().map(user, UserDTOres.class);
    }
}
