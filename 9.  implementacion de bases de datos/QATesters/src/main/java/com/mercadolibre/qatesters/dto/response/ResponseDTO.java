package com.mercadolibre.qatesters.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDTO<T> {
    private T data;
    private LocalDateTime timestamp;

    public ResponseDTO(T data){
        this.data=data;
        this.timestamp=LocalDateTime.now();
    }
}
