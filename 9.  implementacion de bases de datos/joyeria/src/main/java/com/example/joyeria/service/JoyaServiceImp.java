package com.example.joyeria.service;

import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaServiceImp implements IJoyaService{

    private final IJoyaRepository JoyaRepo;

    public JoyaServiceImp (IJoyaRepository repo){
        this.JoyaRepo=repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        return JoyaRepo.findAll();
    }

    @Override
    @Transactional
    public void saveStuden(Joya joya) {
        JoyaRepo.save(joya);
    }

    @Override
    @Transactional
    public void deleteJoya(Long id) {
        JoyaRepo.deleteById(id);

    }

    @Override
    @Transactional (readOnly = true)
    public Joya findJoya(Long id) {
        Joya s = JoyaRepo.findById(id).orElse(null);
        return s;
    }

    @Override
    public Joya updateJoya(Long id, Joya joya) {
        Joya j = findJoya(id);
        j.setNombre(joya.getNombre());
        j.setPeso(joya.getPeso());
        j.setMaterial(joya.getMaterial());
        saveStuden(j);
        return j;
    }

}
