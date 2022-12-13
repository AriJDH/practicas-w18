package com.mercadolibre.Las.Perlas.service;

import com.mercadolibre.Las.Perlas.entity.Joya;
import com.mercadolibre.Las.Perlas.repository.iJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements iJoyaService {
    iJoyaRepository joyaRepository;

    @Autowired
    public JoyaService(iJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getJoyas() {
        return joyaRepository.findAll() ;
    }

    @Override
    public Joya saveJoya(Joya joya) {
        return joyaRepository.save(joya);
    }

    @Override
    public void deleteJoya(Long id) {
        joyaRepository.deleteById(id);
    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }
}
