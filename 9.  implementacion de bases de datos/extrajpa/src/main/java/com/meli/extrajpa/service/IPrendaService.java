package com.meli.extrajpa.service;

import com.meli.extrajpa.dto.PrendaDtoReq;
import com.meli.extrajpa.dto.PrendaDtoRes;

import java.util.List;

public interface IPrendaService {
    public PrendaDtoRes addClothes(PrendaDtoReq prendaDtoReq);
    public List<PrendaDtoRes> getAllClothes();
    public PrendaDtoRes getClothesById(Integer id);
}
