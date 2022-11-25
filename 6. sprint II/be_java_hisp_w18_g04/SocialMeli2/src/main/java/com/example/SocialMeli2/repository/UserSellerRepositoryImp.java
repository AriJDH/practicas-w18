package com.example.SocialMeli2.repository;


import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserSellerRepositoryImp implements IUserSellerRepository {
    List<UserSeller> sellers = new ArrayList<>();

    public UserSellerRepositoryImp() {
        loadSellers();
    }

    @Override
    public UserSeller findById(Integer id) {
        return sellers.stream().filter(buyer -> buyer.getUser_id().equals(id)).findFirst().get();
    }

    @Override
    public List<UserSeller> findAll() {
        return sellers;
    }

    private void loadSellers() {
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:sellers.json");
            sellers = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<UserSeller>>() {
            });
        } catch (Exception ex) {
            System.out.println("Sellers not found " + ex.getMessage());
        }
    }
}
