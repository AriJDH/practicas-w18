package com.example.frescos.service.db;

import com.example.frescos.entity.Batch;
import com.example.frescos.repository.BatchRepository;
import com.example.frescos.repository.InboundOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchDbServiceImpl implements BatchDbService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }
}
