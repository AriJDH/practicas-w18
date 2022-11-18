package com.mercadolibre.linktracker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO {
    private String message;
    private Integer status;
    @JsonFormat(pattern = "yy-MM-dd HH:mm")
    private LocalDateTime timestamp = LocalDateTime.now();
}
