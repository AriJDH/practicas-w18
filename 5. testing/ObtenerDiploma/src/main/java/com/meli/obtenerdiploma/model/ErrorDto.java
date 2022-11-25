package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Getter
public class ErrorDto {
    List<String> messages;
    int status;
    LocalDateTime timeStamp;
}
