package com.example.frescos.controller;

import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fresh-products/batch/list")
public class BatchController {
    @Autowired
    BatchService batchService;

    @GetMapping("/{cantDays}")
    public ResponseEntity<List<BatchResponseDTO>> getRecentPostsFromFollowed(@PathVariable int cantDays, @RequestParam(required=false) String category, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(batchService.getAllBatches(cantDays, category, order));
    }

}
