package com.dh.demojwt.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InboundRequestDTO { // US0001
    @JsonProperty("order_number")
    private Integer orderNumber;
    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("section")
    private SectionRequestDTO section;
    @JsonProperty("batch_stock")
    private Set<BatchRequestDTO> batchStock;

}
