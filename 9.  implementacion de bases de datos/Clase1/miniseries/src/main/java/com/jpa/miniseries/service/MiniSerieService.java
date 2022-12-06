package com.jpa.miniseries.service;

import com.jpa.miniseries.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final IMiniserieRepository miniserieRepository;

    public MiniSerieService(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }
}
