package com.bootcamp.calculadoraCalorias.dto.req;

import com.bootcamp.calculadoraCalorias.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.event.SpringApplicationEvent;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class DishReqDto {
    private String name;
    private Double gr;
}
