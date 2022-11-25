package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorResponseDTO {

    private List<String> messages;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd @HH:mm:ss")
    private LocalDateTime timeStamp;

    //public ErrorResponseDTO(String message) {

    //}

}
