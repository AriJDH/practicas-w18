package com.example.demo.service;

import com.example.demo.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceMiniSerie {

    private final IMiniserieRepository iMiniserieRepository;

    public ServiceMiniSerie(IMiniserieRepository iMiniserieRepository) {
        this.iMiniserieRepository = iMiniserieRepository;
    }
}
