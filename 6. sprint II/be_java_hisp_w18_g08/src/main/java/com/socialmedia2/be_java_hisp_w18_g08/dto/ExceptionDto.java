package com.socialmedia2.be_java_hisp_w18_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionDto {

    private List<String> message;
    private int status;
    private LocalDateTime timStamp;
}
