package com.playground.appathlete.service;


import com.playground.appathlete.dto.request.SportDTOReq;
import com.playground.appathlete.dto.response.AthleteDTOResp;
import com.playground.appathlete.dto.response.SportDTOResp;
import java.util.List;

public interface ISportService {
    List<SportDTOResp> getAll();
    SportDTOResp findSportByName(SportDTOReq sportDtoreq);
    List<AthleteDTOResp> getAllAthlete();

}
