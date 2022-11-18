package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTOres {
    private int code;
    private String message;
}

// JSON REPRESENTATION
// {
//  "message": "",
//  "code": 0
//}