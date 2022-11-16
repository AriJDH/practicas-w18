package com.example.calculadora.service;

import com.example.calculadora.dto.req.MenuDTOReq;
import com.example.calculadora.dto.res.MenuDTORes;

public interface IMenuService {

    MenuDTORes getMenus(MenuDTOReq menuDTO);
}
