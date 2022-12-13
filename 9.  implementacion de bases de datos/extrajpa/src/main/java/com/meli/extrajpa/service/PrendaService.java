package com.meli.extrajpa.service;

import com.meli.extrajpa.dto.PrendaDtoReq;
import com.meli.extrajpa.dto.PrendaDtoRes;
import com.meli.extrajpa.entity.Prenda;
import com.meli.extrajpa.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaService implements IPrendaService {
    private IPrendaRepository prendaRepository;

    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public PrendaDtoRes addClothes(PrendaDtoReq prendaDtoReq) {
        ModelMapper modelMapper = new ModelMapper();

        Prenda prenda = modelMapper.map(prendaDtoReq, Prenda.class);
        Prenda persistPrenda = prendaRepository.save(prenda);

        PrendaDtoRes res = modelMapper.map(persistPrenda, PrendaDtoRes.class);

        return res;
    }

    @Override
    public List<PrendaDtoRes> getAllClothes() {
        ModelMapper modelMapper = new ModelMapper();
        List<Prenda> prendas = prendaRepository.findAll();
        return prendas.stream()
                .map(p -> modelMapper.map(p, PrendaDtoRes.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrendaDtoRes getClothesById(Integer id) {
        return null;
    }
}
