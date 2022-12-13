package com.example.productos.service;

import com.example.productos.domain.Producto;
import com.example.productos.repository.IProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService{
    IProductoRepository productoRepository;

    public ProductoServiceImp(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productoList = new ArrayList<>();
        Iterable<Producto> productoIterable = productoRepository.findAll();
        productoIterable.forEach(producto -> productoList.add(producto));
        return productoList;
    }

    @Override
    public Producto update(String id,Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto findById(String id) {
        return productoRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"El Producto "+id+" no existe"));
    }

    @Override
    public void deleteById(String id) {
        if(findById(id) != null){
            productoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El producto "+id+" no existe");
        }

    }
}
