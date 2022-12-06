package com.dh.joyeria.service;


import com.dh.joyeria.dto.JoyaDtoReq;
import com.dh.joyeria.dto.JoyaDtoRes;

import java.util.List;

public interface IAppService {

    List<JoyaDtoRes> findAll();

    JoyaDtoRes findJoyaById(Long id);

    Long createJoya(JoyaDtoReq joyaDto);

    void changeJoyaVentaONoToFalse(Long id);

    void updateJoya(Long id, JoyaDtoReq joyaDto);
}
