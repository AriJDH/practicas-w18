package com.bootcamp.calculadoraCalorias.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MenuResDto {
    private List<DishDto>dishes;
}
