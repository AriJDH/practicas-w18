package com.example.pedidoderopa.service;

import com.example.pedidoderopa.model.Pedido;
import com.example.pedidoderopa.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements IServi{

    @Autowired
    private IRepo repo;

    @Override
    public Pedido getPedido(int id) {
        return repo.getPedido(id);
    }

    @Override
    public List<Pedido> getAllPedido() {
        return repo.getAllPedidos();
    }
}
