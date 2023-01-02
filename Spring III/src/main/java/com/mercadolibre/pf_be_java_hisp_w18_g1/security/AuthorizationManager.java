package com.mercadolibre.pf_be_java_hisp_w18_g1.security;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Warehouse;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.BadRequestException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.WarehouseDbService;
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
