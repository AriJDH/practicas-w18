package com.jpaHibernate.testerQA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private int status;
}
