package com.example.joyeria.service;

import com.example.joyeria.model.Joya;

import java.util.List;

public interface JoyaService {
    List<Joya> findAllJoyas();
    Joya findById(Long id);
    
}
