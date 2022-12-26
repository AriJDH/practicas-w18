package com.dh.demojwt.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BatchSummaryResponseDTO { //US005
    @JsonProperty("batch_number")
    private Integer batchNumber;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("product_type_id")
    private Integer productTypeId;

    @JsonProperty("due_date")
    private LocalDate dueDate;

    @JsonProperty("current_quantity")
    private Integer currentQuantity;
}
