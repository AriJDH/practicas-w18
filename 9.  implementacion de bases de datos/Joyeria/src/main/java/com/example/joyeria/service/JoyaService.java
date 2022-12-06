package com.example.joyeria.service;

import com.example.joyeria.dto.MessageDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService {
    @Autowired
    private IJoyaRepository repo;

    public MessageDTO save(Joya joya) {
        Joya newJoya = repo.save(joya);
        return new MessageDTO("Joya creada exitosamente con nro identificador" + newJoya.getNro_identificador());
    }

    public List<Joya> getAllJoyas(){
        return repo.findAll().stream().filter(j -> j.isVentaONo() == true).collect(Collectors.toList());
    }

    public Joya getJoya(int id) {
        return repo.findById(id).get();
    }

    public MessageDTO update(Joya joya, int id) {
        if (getJoya(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(
                    "La Joya con id %s no existe", id));
        Joya joyaUpdate = repo.save(joya);
        return new MessageDTO("Joya modificada exitosamente con nro identificador" + joyaUpdate.getNro_identificador());
    }

    public void delete(int id) {
        if (getJoya(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(
                    "La Joya con id %s no existe", id));

        Joya joyaUpdate = getJoya(id);
        joyaUpdate.setVentaONo(false);
        repo.save(joyaUpdate);
    }
}
