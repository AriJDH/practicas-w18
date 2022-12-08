package com.bootcamp.qatester.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDtoReponseStatusMessage {
    private int status;
    private String message;
}
