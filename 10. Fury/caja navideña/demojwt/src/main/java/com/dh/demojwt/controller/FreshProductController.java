package com.dh.demojwt.controller;

import com.dh.demojwt.dto.request.InboundRequestDTO;
import com.dh.demojwt.dto.request.PurchasesRequestDTO;
import com.dh.demojwt.dto.response.ProductStockResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class FreshProductController {
    // *************************************************************************************
    // User Story Name: Ingresar lote en warehouse de fulfillment - US0001
    // *************************************************************************************
    @PostMapping("/inboundorder")
    public ResponseEntity<?> newInboundOrder(@RequestBody InboundRequestDTO inboundRequestDTO){
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/inboundorder")
    public ResponseEntity<?> modifyInboundOrder(@RequestBody InboundRequestDTO inboundRequestDTO){
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    // *************************************************************************************
    // User Story Name: Agregar producto al carrito de compras - US0002
    // *************************************************************************************

    @GetMapping("/list")
    public ResponseEntity<?> getProducts(@RequestParam(required = false) String category){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> newPurchase(@RequestBody PurchasesRequestDTO purchase){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/orders/{idOrder}")
    public ResponseEntity<?> getPurchaseById (@PathVariable Integer id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/orders/{idOrder}")
    public ResponseEntity<?> putPurchaseById (@PathVariable Integer id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // *************************************************************************************
    // User Story Name: Consultar ubicacion de un producto en el warehouse - US0003
    // *************************************************************************************
    @GetMapping("/orders/{idProduct}/batch/list")
    public ResponseEntity <?> getProductsBach(@PathVariable Integer id, @RequestParam(required = false) String order){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // *************************************************************************************
    // User Story Name: Consultar el stock de un producto en todos los warehouses  - US0004
    // *************************************************************************************

    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<?> getStockQuantity (@PathVariable Integer id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // *************************************************************************************
    // User Story Name: Consultar fecha de vencimiento por lote - US0005
    // *************************************************************************************
    @GetMapping("/batch/list/due-date/{cantDays}")
    public ResponseEntity<?> getBatchesDueDate(@PathVariable Integer cantDays, @RequestParam(required = false) String category, @RequestParam(required = false) String order){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
