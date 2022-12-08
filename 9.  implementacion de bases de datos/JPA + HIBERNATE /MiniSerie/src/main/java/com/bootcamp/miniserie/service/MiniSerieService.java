package com.bootcamp.miniserie.service;

import com.bootcamp.miniserie.repository.IMiniSerieRepository;

public class MiniSerieService {
    private final IMiniSerieRepository iMiniSerieRepository;

    public MiniSerieService(IMiniSerieRepository iMiniSerieRepository) {
        this.iMiniSerieRepository = iMiniSerieRepository;
    }
}
