package com.bootcamp.calculadoraCalorias.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MenuReqDto {
    List<DishReqDto>dishes;
}
