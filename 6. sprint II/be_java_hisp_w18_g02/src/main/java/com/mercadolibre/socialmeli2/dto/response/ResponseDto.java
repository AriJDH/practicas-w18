package com.mercadolibre.socialmeli2.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ResponseDto {
    private List<String> messages;
    private int status;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    public ResponseDto(){
        this.messages = new ArrayList<>();
        this.timestamp = LocalDateTime.now();
    }

    public ResponseDto(String message, int status){
        this.messages = new ArrayList<>();
        this.messages.add(message);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ResponseDto(List<String> messages, int status){
        this.messages = messages;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

}