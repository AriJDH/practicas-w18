package com.dh.demojwt.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockResponseDTO { // US0001
    @JsonProperty("batch_number")
    private Integer batchNumber;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("current_temperature")
    private Double currentTemperature;

    @JsonProperty("minimum_temperature")
    private Double minimumTemperature;

    @JsonProperty("initial_quantity")
    private Integer initialQuantity;

    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @JsonProperty("manufacturing_date")
    private LocalDate manufacturingDate;

    @JsonProperty("manufacturing_time")
    private LocalDateTime manufacturingTime;

    @JsonProperty("due_date")
    private LocalDate dueDate;
}
