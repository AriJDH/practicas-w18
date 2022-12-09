package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.req.GetReqDto;
import com.bootcamp.joyeria.dto.view.GemSaveView;
import com.bootcamp.joyeria.dto.view.GemView;

import java.util.List;

public interface IGemService {

    GemSaveView save(GetReqDto reqDto);
    List<GemView> findAll();
    void deleteById(Long id);
    GemView updateById(Long id, GetReqDto dto);
}
