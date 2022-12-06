package com.meli.joyeriaApp.service;


import com.meli.joyeriaApp.exception.EntityNotFoundException;
import com.meli.joyeriaApp.exception.IncorrectJoyaException;
import com.meli.joyeriaApp.model.Joya;
import com.meli.joyeriaApp.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaDbServiceImplementation implements JoyaDbService {
    @Autowired
    private JoyaRepository joyaRepository;

    @Override
    public List<Joya> findAllJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    public Joya findById(Long id) {
        return joyaRepository.findById(id).orElseThrow(()->{throw new EntityNotFoundException("El usuario " + id +" no existe.");});
    }

    @Override
    public void deleteById(Long id) {
        Joya savedJoya = findById(id);
        if(savedJoya.getVentaONo())
            throw new IncorrectJoyaException("La joya a eliminar no puede estar a la venta.");
        else
            joyaRepository.deleteById(id);
    }

    @Override
    public Joya save(Joya joya) {
        if(joya.getVentaONo())
            return joyaRepository.save(joya);
        else
            throw new IncorrectJoyaException("La joya a eliminar no puede estar a la venta.");
    }

    @Override
    public Joya update(Long id, Joya joya) {
        joya.setNro_identificatorio(id);
        return joyaRepository.save(joya);
    }
}
