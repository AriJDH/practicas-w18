package com.youtuber.youtubeexcepciones.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExceptionDTO {

    private String message;
    private int status;
}
