package com.example.SocialMeli2.repository;

import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserBuyerRepositoryImp implements IUserBuyerRepository {
    List<UserBuyer> buyers = new ArrayList();

    public UserBuyerRepositoryImp() {
        loadBuyers();
    }


    @Override
    public Optional<UserBuyer> findById(Integer id) {
        return buyers.stream().filter(buyer -> buyer.getUser_id().equals(id)).findFirst();
    }

    @Override
    public List<UserBuyer> findAll() {
        return buyers;
    }


    private void loadBuyers() {
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:buyers.json");
            buyers = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<UserBuyer>>() {
            });
        } catch (Exception ex) {
            System.out.println("Buyers not found " + ex.getMessage());
        }
    }

}
