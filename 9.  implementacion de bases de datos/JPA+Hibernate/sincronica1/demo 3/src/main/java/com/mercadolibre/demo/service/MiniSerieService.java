package com.mercadolibre.demo.service;

import com.mercadolibre.demo.repository.MiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    MiniSerieRepository miniSerieRepository;

    public MiniSerieService(MiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
