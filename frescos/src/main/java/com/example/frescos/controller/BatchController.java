package com.example.frescos.controller;

import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/batch/list/due-date")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @GetMapping("/{cantDays}")
    public ResponseEntity<List<BatchResponseDTO>> getRecentPostsFromFollowed(Authentication authentication, @PathVariable int cantDays, @RequestParam(required=false) String category, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(batchService.getAllBatches(authentication, cantDays, category, order));
    }

}
