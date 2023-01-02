package com.mercadolibre.pf_be_java_hisp_w18_g1.controller;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.BatchForStockDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response.BatchStockDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/batch/list/due-date")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @GetMapping("/{cantDays}")
    public ResponseEntity<BatchStockDTO> getRecentPostsFromFollowed(Authentication authentication,
                                                                       @PathVariable int cantDays,
                                                                       @RequestParam(required=false) String category,
                                                                       @RequestParam(required = false) String order
    ) {
        BatchStockDTO batch_stock = new BatchStockDTO(batchService.getAllBatches(authentication,
                cantDays, category, order));

        return ResponseEntity.ok(batch_stock);
    }

}
