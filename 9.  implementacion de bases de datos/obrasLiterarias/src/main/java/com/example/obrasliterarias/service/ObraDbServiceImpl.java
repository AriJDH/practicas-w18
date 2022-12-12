package com.example.obrasliterarias.service;

import com.example.obrasliterarias.domain.Obra;
import com.example.obrasliterarias.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraDbServiceImpl implements ObraDbService{
    @Autowired
    private ObraRepository obraRepository;

    @Override
    public Obra save(Obra obra) {
        return obraRepository.save(obra);
    }

    @Override
    public List<Obra> findAll() {
        return obraRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        obraRepository.deleteById(id);
    }

    @Override
    public Obra findByNombreAutor(String nombreAutor) {
        Optional<Obra> optObra =  obraRepository.findByNombreAutor(nombreAutor);
        if(optObra.isPresent())
            return optObra.get();
        else
            return null;
    }

    @Override
    public List<Obra> findByTitleSubstring(String substring) {
        return obraRepository.findByTitleSubstring(substring);
    }

    @Override
    public List<Obra> findByPagesGreaterThan(int pages) {
        return obraRepository.findByPagesGreaterThan(pages);
    }

    @Override
    public List<Obra> findAllPublishedBefore(int anio) {
        return obraRepository.findAllPublishedBefore(anio);
    }

    @Override
    public List<Obra> findAllPublishedAfter(int anio) {
        return obraRepository.findAllPublishedAfter(anio);
    }

    @Override
    public List<Obra> findAllByEditorial(String editorial) {
        return obraRepository.findAllByEditorial(editorial);
    }
}
