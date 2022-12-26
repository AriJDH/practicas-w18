package com.example.melifrescos.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BatchDTO {
    private Long batchNumber;
    private Long productId;
    private Double currentTemperature;
    private Double minimumTemperature;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDateTime manufacturingTime;
    private LocalDate dueDate;
}
