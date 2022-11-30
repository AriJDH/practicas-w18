package com.meli.obtenerdiploma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private List<String> messages;
    private int status;
    private LocalDateTime timestamp;

    public ErrorDTO(String message, HttpStatus status) {
        this.messages = Arrays.asList(message);
        this.status = status.value();
        this.timestamp = LocalDateTime.now();
    }
}
