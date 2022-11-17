package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import org.modelmapper.ModelMapper;

import java.util.List;

public class DTOMapper {
    private static ModelMapper mapper;
    public static ModelMapper getInstance() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }
    public static UserPostsDTOres mapTo(User user){
        return mapper.map(user, UserPostsDTOres.class);
    }

    public static UserFollowedDTOres mapToUserFollowedRes(User user){
        return mapper.map(user, UserFollowedDTOres.class);
    }

    public static UserFollowersListDTOres mapToUserFollowersRes(List<User> users){
        return mapper.map(users, UserFollowersListDTOres.class);
    }

    public static Post mapToPost(PostDTOreq postDTOreq){



        return null;
    }
}
