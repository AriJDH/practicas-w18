package com.dh.joyeria.service;

import com.dh.joyeria.dto.JoyaDtoReq;
import com.dh.joyeria.dto.JoyaDtoRes;
import com.dh.joyeria.entity.Joya;
import com.dh.joyeria.repository.IJoyeriaRepository;
import com.dh.joyeria.util.MapDto;
import com.dh.joyeria.util.MapEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppService implements IAppService {

    private final IJoyeriaRepository repository;

    public AppService(IJoyeriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<JoyaDtoRes> findAll() {
        return repository
                .findByVentaONoTrue()
                .stream()
                .map(MapDto::map)
                .toList();
    }

    @Override
    public JoyaDtoRes findJoyaById(Long id) {
        Optional<Joya> joya = repository.findById(id);
        return joya
                .map(MapDto::map)
                .orElseThrow();
    }

    @Override
    public Long createJoya(JoyaDtoReq joyaDto) {
        Joya joya = MapEntity.map(joyaDto);
        return repository.save(joya).getId();
    }

    @Override
    public void changeJoyaVentaONoToFalse(Long id) {
        repository.updateJoyaVentaONo(id);
    }

    @Override
    public void updateJoya(Long id, JoyaDtoReq joyaDto) {
        Joya joya = repository.findById(id).orElseThrow();
        Joya newJoya = MapEntity.map(joyaDto);
        newJoya.setId(id);
        repository.save(newJoya);
    }
}
