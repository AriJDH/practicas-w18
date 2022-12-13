package com.example.empresa_elasticsearch.service;

import com.example.empresa_elasticsearch.domain.Producto;
import com.example.empresa_elasticsearch.dto.CreacionProductoDTO;
import com.example.empresa_elasticsearch.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public String crearProducto(CreacionProductoDTO creacionProductoDTO) {

        Producto producto = this.modelMapper.map(creacionProductoDTO, Producto.class);

        this.productoRepository.save(producto);

        return "Creado exitosamente";
    }
}
