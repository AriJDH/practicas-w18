package com.meli.joyeriaApp.service;


import com.meli.joyeriaApp.model.Joya;

import java.util.List;

public interface JoyaDbService {
    List<Joya> findAllJoyas();
    Joya findById(Long id);
    void deleteById(Long id);
    Joya save(Joya joya);
    Joya update(Long id, Joya joya);
}
