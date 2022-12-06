package com.lasperlas.lasperlas.service;

import com.lasperlas.lasperlas.dto.JoyaDTO;
import com.lasperlas.lasperlas.dto.ResponseDTO;
import com.lasperlas.lasperlas.dto.UpdateDTO;

import java.util.List;


public interface IJoyasService {

    public ResponseDTO create(JoyaDTO joyita);
    public ResponseDTO delete(Long  id);
    public ResponseDTO update(Long  id, UpdateDTO joyita);
    public List<JoyaDTO> getAll();

}
