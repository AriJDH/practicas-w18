package com.example.frescos.service.db;

import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.entity.Batch;

import java.util.List;

public interface BatchDbService {
    List<Batch> getAllBatches();
}
