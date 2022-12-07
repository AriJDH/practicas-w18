package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.request.jerwelyCreateResponse;
import com.example.joyerialasperlas.model.Jewerly;

import java.util.List;

public interface IJewerlyService {
    public List<Jewerly> obtenerJoyas();
    public jerwelyCreateResponse guardarJoyas(Jewerly jewerly);
    public String borrarJoyas(Long idjewerly);
    public Jewerly encontrarJoya(Long idjewerly);
    public String editarJoya(Long idjewerly, Jewerly jewerly);
}
