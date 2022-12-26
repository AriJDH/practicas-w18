package com.dh.demojwt.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockQuantityResponseDTO {

    @JsonProperty("batch_number")
    private Integer id;

    @JsonProperty("current_quantity")
    private Integer currentQuantity;

    @JsonProperty("due_date")
    private LocalDate dueDate;


}
