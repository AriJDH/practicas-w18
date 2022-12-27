package com.example.frescos.service;

import com.example.frescos.dtos.WarehouseDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDTO> findByProduct(Authentication authentication, Long id, Character order);
}
