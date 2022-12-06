package com.example.joyeria.service;

import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoyaServiceImplementation implements JoyaService{
    @Autowired
    private JoyaRepository joyaRepository;

}
