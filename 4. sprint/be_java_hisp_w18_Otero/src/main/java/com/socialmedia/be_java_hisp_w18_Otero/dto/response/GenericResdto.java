package com.socialmedia.be_java_hisp_w18_Otero.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GenericResdto {

    private String message;
    private Integer status;
}
