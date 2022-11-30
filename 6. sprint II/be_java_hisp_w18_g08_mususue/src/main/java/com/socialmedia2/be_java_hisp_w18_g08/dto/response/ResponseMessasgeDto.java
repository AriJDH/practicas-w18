package com.socialmedia2.be_java_hisp_w18_g08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseMessasgeDto {
    String message;
    int status;
    LocalDateTime timeStamp;
}
