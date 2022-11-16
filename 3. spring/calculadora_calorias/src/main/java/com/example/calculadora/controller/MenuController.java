package com.example.calculadora.controller;

import com.example.calculadora.dto.req.MenuDTOReq;
import com.example.calculadora.dto.res.MenuDTORes;
import com.example.calculadora.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private IMenuService menuService;

    @Autowired
    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/getMenu")
    public ResponseEntity<MenuDTORes> getMenus(@RequestBody MenuDTOReq menuDTO){
        return new ResponseEntity<>(menuService.getMenus(menuDTO), HttpStatus.OK);
    }
}
