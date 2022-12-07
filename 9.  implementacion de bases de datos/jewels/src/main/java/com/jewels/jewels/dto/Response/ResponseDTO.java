package com.jewels.jewels.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ResponseDTO {
    private String message;
    private Integer code;
}
