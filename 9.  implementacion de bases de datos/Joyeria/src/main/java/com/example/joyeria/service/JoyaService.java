package com.example.joyeria.service;

import com.example.joyeria.dto.MessageDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService {
    @Autowired
    private IJoyaRepository iJoyaRepository;

    public MessageDTO save(Joya joya) {
        Joya joyaNueva = iJoyaRepository.save(joya);
        return new MessageDTO("Item dado de alta. Nro de ID: " + joyaNueva.getNro_identificatorio());
    }

    public List<Joya> getAllJoyas(){
        return iJoyaRepository.findAll().stream().filter(Joya::isVentaONo).collect(Collectors.toList());
    }

    public Joya getJoya(int id) {
        return iJoyaRepository.findById(id).get();
    }

    public MessageDTO update(Joya joya, int id) {
        if (getJoya(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(
                    "Item id %s no existe", id));
        Joya joyaUpdate = iJoyaRepository.save(joya);
        return new MessageDTO("Item modificada exitosamente. Nro de ID: " + joyaUpdate.getNro_identificatorio());
    }

    public void delete(int id) {
        if (getJoya(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(
                    "Item id %s no existe", id));

        Joya joyaUpdate = getJoya(id);
        joyaUpdate.setVentaONo(false);
        iJoyaRepository.save(joyaUpdate);
    }
}
