package com.example.joyeria_lasperlas.service;


import com.example.joyeria_lasperlas.dto.request.JewelDTORequest;
import com.example.joyeria_lasperlas.dto.response.JewelDTOResponse;

import java.util.List;

public interface IServiceJewerly {
    public List<JewelDTOResponse> getJewerly();
    public Long saveJewel(JewelDTORequest jewelDTORequest);
    public Boolean logicDelete(Long id);
    public JewelDTOResponse updateJewel(JewelDTORequest jewelDTORequest);
}
