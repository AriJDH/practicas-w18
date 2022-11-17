package com.socialmeli.be_java_hisp_w18g05.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorExceptionDTOResponse {
    private String message;

    private int status;
}
