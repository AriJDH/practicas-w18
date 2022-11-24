package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    private List<String> messages;
    private int status;
    private LocalDateTime timeStamp;

    public ErrorResponseDTO(String message) {
    }
}
