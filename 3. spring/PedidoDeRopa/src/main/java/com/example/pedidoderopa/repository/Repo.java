package com.example.pedidoderopa.repository;

import com.example.pedidoderopa.model.Pedido;
import com.example.pedidoderopa.model.Ropa;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Repo implements IRepo{

    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public Pedido getPedido(int id) {
        return getAllPedidos().stream().filter(p -> p.getNumero() == id).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No se encontro pedido numero %s", id)));
    }

    @Override
    public List<Pedido> getAllPedidos() {
        pedidos.add(new Pedido(1,List.of(new Ropa("Buzo",10), new Ropa("Camisa",99))));
        pedidos.add(new Pedido(2,List.of(new Ropa("Buzo",10))));
        pedidos.add(new Pedido(3,List.of(new Ropa("Buzo",10))));
        pedidos.add(new Pedido(4,List.of(new Ropa("Buzo",10))));

        return pedidos;
    }
}
