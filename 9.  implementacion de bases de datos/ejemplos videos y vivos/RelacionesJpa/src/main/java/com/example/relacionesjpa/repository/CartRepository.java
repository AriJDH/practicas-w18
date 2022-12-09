package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.entity.OneToMany.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

}
