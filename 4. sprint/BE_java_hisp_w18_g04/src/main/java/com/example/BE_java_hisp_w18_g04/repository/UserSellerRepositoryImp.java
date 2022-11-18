package com.example.BE_java_hisp_w18_g04.repository;


import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.User;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;
import com.example.BE_java_hisp_w18_g04.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserSellerRepositoryImp implements IUserSellerRepository{
    List<UserSeller> sellers = new ArrayList<>();

    public UserSellerRepositoryImp() {
        loadSellers();
    }

    public UserSeller findById(Integer id) {
        return sellers.stream().filter(buyer -> buyer.getUser_id().equals(id)).findFirst().get();
    }

    public List<UserSeller> findAll(){
        return sellers;
    }

    private void loadSellers(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:sellers.json");
            sellers = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<UserSeller>>() {});
        }catch (Exception ex){
            System.out.println("Sellers not found " + ex.getMessage());
        }
    }

    @Override
    public Long finAllPostPromo(Integer user_id) {
        Long countPostPromo = sellers.stream()
                .findFirst().filter(userSeller -> user_id.equals(user_id)).get().getPosts().stream()
                .filter(post -> post.getHas_promo().equals(true)).collect(Collectors.toList())
                .stream().count();
        return countPostPromo;
    }
}
