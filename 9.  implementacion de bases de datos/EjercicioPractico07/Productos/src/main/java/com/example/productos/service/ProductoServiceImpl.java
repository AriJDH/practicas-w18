package com.example.productos.service;

import com.example.productos.dto.request.ProductoRequest;
import com.example.productos.dto.response.ProductoResponse;
import com.example.productos.entity.Producto;
import com.example.productos.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;


    @Override
    public ProductoResponse createProducto(ProductoRequest request) {

        Producto entity = new Producto();
        entity.setNombre(request.getNombre());
        entity.setTipo(request.getTipo());
        entity.setPrecioVenta(request.getPrecioVenta());
        entity.setPrecioCosto(request.getPrecioCosto());
        entity.setCantidadDisponible(request.getCantidadDisponible());

        Producto productoSaved = productoRepository.save(entity);
        ProductoResponse result = new ProductoResponse();
        result.setNombre(productoSaved.getNombre());
        result.setTipo(productoSaved.getTipo());
        result.setPrecioVenta(productoSaved.getPrecioVenta());
        result.setPrecioCosto(productoSaved.getPrecioCosto());
        result.setCantidadDisponible(productoSaved.getCantidadDisponible());

        return result;
    }

    @Override
    public ProductoResponse updateProducto(String id, ProductoRequest request) {

        if (productoRepository.existsById(id)){

            Producto productoUpdated = new Producto();
            productoUpdated.setId(id);
            productoUpdated.setNombre(request.getNombre());
            productoUpdated.setTipo(request.getTipo());
            productoUpdated.setPrecioVenta(request.getPrecioVenta());
            productoUpdated.setPrecioCosto(request.getPrecioCosto());
            productoUpdated.setCantidadDisponible(request.getCantidadDisponible());

            productoRepository.save(productoUpdated);
            ProductoResponse result = new ProductoResponse();
            result.setNombre(productoUpdated.getNombre());
            result.setTipo(productoUpdated.getTipo());
            result.setPrecioVenta(productoUpdated.getPrecioVenta());
            result.setPrecioCosto(productoUpdated.getPrecioCosto());
            result.setCantidadDisponible(productoUpdated.getCantidadDisponible());

            return result;
        }

        return null;
    }

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

}
