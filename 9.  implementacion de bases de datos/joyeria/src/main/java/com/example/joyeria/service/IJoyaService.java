package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaDtoReq;
import com.example.joyeria.dto.response.JoyaDtoRsp;

import java.util.List;

public interface IJoyaService {

    public Long saveJoya(JoyaDtoReq joya);
    public List<JoyaDtoRsp> getJoyas();
    public void deleteJoya(Long id);
    public JoyaDtoRsp findJoya(Long id);
    public JoyaDtoRsp modifyJoya(Long id, JoyaDtoReq joya);

}
