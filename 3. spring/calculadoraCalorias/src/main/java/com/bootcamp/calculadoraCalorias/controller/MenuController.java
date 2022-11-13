package com.bootcamp.calculadoraCalorias.controller;

import com.bootcamp.calculadoraCalorias.dto.req.MenuReqDto;
import com.bootcamp.calculadoraCalorias.dto.res.MenuResDto;
import com.bootcamp.calculadoraCalorias.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @PostMapping("/getMenu")
    public ResponseEntity<MenuResDto> getMenus(@RequestBody MenuReqDto dto){
        return new ResponseEntity<>(menuService.getMenus(dto), HttpStatus.OK);
    }
}
