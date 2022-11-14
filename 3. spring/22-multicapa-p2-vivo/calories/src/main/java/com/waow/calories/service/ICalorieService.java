package com.waow.calories.service;

import com.waow.calories.dto.request.PlateDTOReq;
import com.waow.calories.dto.response.PlateDTORes;

import java.util.List;

public interface ICalorieService {
    PlateDTORes getPlateInfoByNameGrams(String plateName, int plateGrams);
    List<PlateDTORes> getPlatesInfoByDTO(PlateDTOReq plateDTOReq);
}
