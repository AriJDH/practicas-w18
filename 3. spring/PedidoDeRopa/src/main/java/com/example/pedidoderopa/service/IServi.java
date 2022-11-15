package com.example.pedidoderopa.service;

import com.example.pedidoderopa.model.Pedido;

import java.util.List;

public interface IServi {

    Pedido getPedido(int id);

    List<Pedido> getAllPedido();
}
