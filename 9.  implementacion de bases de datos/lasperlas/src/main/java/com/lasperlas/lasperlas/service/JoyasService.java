package com.lasperlas.lasperlas.service;

import com.lasperlas.lasperlas.dto.JoyaDTO;
import com.lasperlas.lasperlas.dto.ResponseDTO;
import com.lasperlas.lasperlas.dto.UpdateDTO;
import com.lasperlas.lasperlas.entity.Joya;
import com.lasperlas.lasperlas.repository.IJoyasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyasService implements IJoyasService {

    @Autowired
    IJoyasRepository joyasRepository;

    @Override
    @Transactional
    public ResponseDTO create(JoyaDTO joyita) {
        Joya joya = new Joya(joyita.getNombre(),joyita.getMaterial(),joyita.getPeso(),joyita.getParticularidad(),joyita.getPosee_piedra(),joyita.getVentaONo());
        Joya resp = joyasRepository.save(joya);
        return new ResponseDTO(201, "Joya " + resp.getNro_identificatorio().toString() + " creada exitosamente");
    }

    @Override
    public ResponseDTO delete(Long id) {
        if (joyasRepository.existsById(id)){
            Joya joyita = joyasRepository.findById(id).get();
            joyita.setVentaONo(false);
            joyasRepository.save(joyita);
            return new ResponseDTO(200,"La joya " + joyita.getNro_identificatorio() + " ha sido eliminada");
        }
        else {
            return new ResponseDTO(400,"La joya que desea eliminar no existe");
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<JoyaDTO> getAll() {
       List<Joya> joyitas = joyasRepository.findAll();
       return joyitas.stream().filter(p -> p.getVentaONo()).map(p -> new JoyaDTO(p.getNombre(),p.getMaterial(),p.getPeso(),p.getParticularidad(),p.getPosee_piedra(),p.getVentaONo())).collect(Collectors.toList());
    }
    
    @Override
    public ResponseDTO update(Long id, UpdateDTO joyita) {
        if (joyasRepository.existsById(id)){
            Joya joya = joyasRepository.findById(id).get();
            if (joyita.getPosee_piedra() != null){
                joya.setPosee_piedra(joyita.getPosee_piedra());
            }
            if (joyita.getNombre() != null){
                joya.setNombre(joyita.getNombre());
            }
            if (joyita.getPeso() != null){
                joya.setPeso(joyita.getPeso());
            }
            if (joyita.getParticularidad() != null){
                joya.setParticularidad(joyita.getParticularidad());
            }
            if (joyita.getMaterial() != null){
                joya.setMaterial(joyita.getMaterial());
            }
            joyasRepository.save(joya);
            return new ResponseDTO(200,"La joya " + joya.getNro_identificatorio() + " ha sido actualizada");
        }
        else {
            return new ResponseDTO(400,"La joya que desea actualizar no existe");
        }
    }
}
