package com.example.frescos.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BatchResponseDTO {
    @JsonProperty("batch_number")
    private Long batchNumber;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("product_type_id")
    private Integer productTypeId;
    @JsonProperty("due_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
    @JsonProperty("current_quantity")
    private Integer currentQuantity;
}
