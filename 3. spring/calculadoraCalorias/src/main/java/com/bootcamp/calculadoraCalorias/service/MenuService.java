package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.dto.req.DishReqDto;
import com.bootcamp.calculadoraCalorias.dto.req.MenuReqDto;
import com.bootcamp.calculadoraCalorias.dto.res.DishDto;
import com.bootcamp.calculadoraCalorias.dto.res.MenuResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService implements IMenuService {
    @Autowired
    private IDishService dishService;


    @Override
    public MenuResDto getMenus(MenuReqDto dto) {
        MenuResDto menuResDto=new MenuResDto();
       menuResDto.setDishes( dto.getDishes().stream()
                .map(dto1 -> dishService.getData(dto1))
                .collect(Collectors.toList()));
        return menuResDto;
    }
}
