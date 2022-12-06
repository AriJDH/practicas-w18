package com.example.joyeria.service;

import com.example.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoyas();
    public void saveStuden(Joya joya);
    public void deleteJoya(Long id);
    public Joya findJoya(Long id);
    public Joya updateJoya(Long id, Joya joya);
}
