package com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository{
    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User entity);
    void deleteById(Integer id);
    Integer update(User entity);



}
