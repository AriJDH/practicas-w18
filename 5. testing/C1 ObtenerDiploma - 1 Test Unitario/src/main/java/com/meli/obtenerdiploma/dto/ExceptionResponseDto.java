package com.meli.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExceptionResponseDto {
    private List<String> messages;
    //private String message;
    private int status;
    private LocalDate timeStamp;

    public ExceptionResponseDto(String message) {
    }
}
