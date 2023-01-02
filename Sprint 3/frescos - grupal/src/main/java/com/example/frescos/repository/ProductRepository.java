package com.example.frescos.repository;

import com.example.frescos.entity.Product;
import com.example.frescos.enums.SectionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory(String category);
    List<Product> findBySectionCode(SectionCode sectionCode);
}
