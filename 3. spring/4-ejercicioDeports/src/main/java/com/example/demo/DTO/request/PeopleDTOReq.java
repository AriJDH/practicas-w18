package com.example.demo.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PeopleDTOReq {
    private String name;
    private String lastname;
    private int age;
    private String listDeports;
}
