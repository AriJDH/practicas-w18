package com.example.pedidoderopa.controller;

import com.example.pedidoderopa.model.Pedido;
import com.example.pedidoderopa.service.IServi;
import com.example.pedidoderopa.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private IServi service;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable int id){

        return new ResponseEntity(service.getPedido(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Pedido> getAllPedido(){
        return new ResponseEntity(service.getAllPedido(), HttpStatus.OK);
    }
}
