package com.example.frescos.controller;

import com.example.frescos.dtos.BatchForStockDTO;
import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.dtos.response.BatchStockDTO;
import com.example.frescos.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/batch/list/due-date")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @GetMapping("/{cantDays}")
    public ResponseEntity<BatchStockDTO> getRecentPostsFromFollowed(Authentication authentication, @PathVariable int cantDays, @RequestParam(required=false) String category, @RequestParam(required = false) String order) {
        BatchStockDTO batch_stock = new BatchStockDTO(batchService.getAllBatches(authentication, cantDays, category, order));

        return ResponseEntity.ok(batch_stock);
    }

}
