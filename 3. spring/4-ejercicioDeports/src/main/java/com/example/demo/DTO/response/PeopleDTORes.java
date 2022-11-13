package com.example.demo.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PeopleDTORes {
    private String name;
    private String lastname;
    private String listDeports;
}
