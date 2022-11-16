package com.example.calculadora.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MenuDTOReq {

    private List<PlateDTOReq> plates;
}
