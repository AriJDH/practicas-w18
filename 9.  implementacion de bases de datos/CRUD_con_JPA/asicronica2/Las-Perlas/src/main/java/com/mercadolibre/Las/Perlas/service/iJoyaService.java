package com.mercadolibre.Las.Perlas.service;

import com.mercadolibre.Las.Perlas.entity.Joya;

import java.util.List;

public interface iJoyaService {
    public List<Joya> getJoyas();
    public Joya saveJoya(Joya joya);
    public void deleteJoya(Long id);
    public Joya findJoya(Long id);
}
