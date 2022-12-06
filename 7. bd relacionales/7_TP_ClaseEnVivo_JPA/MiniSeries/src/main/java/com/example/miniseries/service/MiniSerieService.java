package com.example.miniseries.service;

import com.example.miniseries.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final IMiniSerieRepository iMiniserieRepository;

    public MiniSerieService(IMiniSerieRepository iMiniserieRepository) {
        this.iMiniserieRepository = iMiniserieRepository;
    }
}
