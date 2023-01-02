package com.example.frescos.security;

import com.example.frescos.entity.Warehouse;
import com.example.frescos.exception.BadRequestException;
import com.example.frescos.service.db.WarehouseDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationManager {
    @Autowired
    private WarehouseDbService warehouseDbService;

    public void checkWarehouseAuthorization(Long warehouseCode, Authentication authentication){
        Warehouse warehouse = warehouseDbService.findByWarehouseCode(warehouseCode);
        if(!warehouse.getAgent().getUserName().equals(authentication.getName()))
            throw new BadRequestException("Usted no está autorizado para agregar un lote al warehouse " + warehouse + ".");
    }
}
