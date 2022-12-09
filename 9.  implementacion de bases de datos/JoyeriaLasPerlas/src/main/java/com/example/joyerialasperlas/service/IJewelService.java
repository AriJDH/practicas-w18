package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.request.CreateJewelRequestDto;
import com.example.joyerialasperlas.dto.response.JewelResponseDto;
import com.example.joyerialasperlas.dto.response.JewelDto;

import java.util.List;

public interface IJewelService {

    JewelResponseDto createJewel(CreateJewelRequestDto jewel);
    List<JewelDto> getJewels();

    JewelResponseDto deleteJewel(Long id);
    CreateJewelRequestDto updateJewel(Long id, CreateJewelRequestDto updateJewel);
}
