package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.response.JerwelyDtoResponse;
import com.example.joyerialasperlas.model.Jewerly;

import java.util.List;

public interface IJewerlyService {
    public List<Jewerly> obtenerJoyas();
    public JerwelyDtoResponse guardarJoyas(Jewerly jewerly);
    public JerwelyDtoResponse borrarJoyas(Long idjewerly);
    public Jewerly encontrarJoya(Long idjewerly);
    public Jewerly editarJoya(Long idjewerly, Jewerly jewerly);
}
