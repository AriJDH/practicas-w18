package com.bootcamp.calculadoraCalorias.service;


import com.bootcamp.calculadoraCalorias.dto.req.DishReqDto;
import com.bootcamp.calculadoraCalorias.dto.req.MenuReqDto;
import com.bootcamp.calculadoraCalorias.dto.res.DishDto;
import com.bootcamp.calculadoraCalorias.dto.res.MenuResDto;

import java.util.List;

public interface IMenuService {

    MenuResDto getMenus(MenuReqDto dto);
}
