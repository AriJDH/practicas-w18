package com.mercadolibre.covid.service;

import com.mercadolibre.covid.repository.ISaludRepository;
import com.mercadolibre.covid.repository.SaludRepository;
import org.springframework.stereotype.Service;

@Service
public class SaludService implements ISaludService{
    private final ISaludRepository repo;

    public SaludService(SaludRepository repo) {
        this.repo = repo;
    }
}
