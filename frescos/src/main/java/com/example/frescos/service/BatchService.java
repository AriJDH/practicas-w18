package com.example.frescos.service;

import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.entity.Batch;
import org.springframework.security.core.Authentication;

import java.time.LocalDate;
import java.util.List;

public interface BatchService {

    List<BatchResponseDTO> getAllBatches(Authentication authentication,Integer amountDays, String category, String order );
}
