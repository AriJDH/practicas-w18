package com.modulospring.demoParams.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTOReq {
    private String name;
    private String lastname;
    private String mensage;
}
