package com.example.frescos.service;

import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.entity.Batch;

import java.time.LocalDate;
import java.util.List;

public interface BatchService {

    List<BatchResponseDTO> getAllBatches(Integer amountDays, String category, String order );
}
