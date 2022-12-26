package com.dh.demojwt.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequestDTO { //US002
    @JsonProperty("status_code")
    private String statusCode;
}
