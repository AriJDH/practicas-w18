package com.example.joyeria.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Integer status;
    private String message;
}
