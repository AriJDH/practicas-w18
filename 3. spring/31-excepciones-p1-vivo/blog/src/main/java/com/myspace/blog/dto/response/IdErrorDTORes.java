package com.myspace.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IdErrorDTORes {
    private String message;
    private HttpStatus status;
}
