package com.example.pedidoderopa.repository;

import com.example.pedidoderopa.model.Pedido;

import java.util.List;

public interface IRepo {

    Pedido getPedido(int id);

    List<Pedido> getAllPedidos();
}
