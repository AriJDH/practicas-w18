package com.example.calculadora.service.impl;

import com.example.calculadora.dto.req.MenuDTOReq;
import com.example.calculadora.dto.res.MenuDTORes;
import com.example.calculadora.service.IMenuService;
import com.example.calculadora.service.IPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuService implements IMenuService {

    private IPlateService plateService;

    @Autowired
    public MenuService(IPlateService plateService) {
        this.plateService = plateService;
    }

    @Override
    public MenuDTORes getMenus(MenuDTOReq menuDTO) {
        MenuDTORes menuDTORes = new MenuDTORes();
        menuDTORes.setPlates(menuDTO.getPlates().stream()
                .map(dto1 -> plateService.getData(dto1))
                .collect(Collectors.toList()));
        return menuDTORes;
    }
}
