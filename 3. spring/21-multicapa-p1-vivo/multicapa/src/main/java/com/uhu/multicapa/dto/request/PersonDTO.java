package com.uhu.multicapa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonDTO {
    private String firstname;
    private String lastname;
    private int age;
}
