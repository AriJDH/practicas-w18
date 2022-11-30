package com.example.socialmeli2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorValidationListResponse {

    private List<ErrorValidationResponse> errorValidationResponseList;

}
