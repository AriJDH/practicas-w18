package com.example.clavecompuesta.service;

import com.example.clavecompuesta.DTO.CompraDTO;
import com.example.clavecompuesta.entity.Compra;
import com.example.clavecompuesta.repository.IRepositoryCompra;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCompraImp implements IServiceCompra{

    private final IRepositoryCompra iRepositoryCompra;

    public ServiceCompraImp(IRepositoryCompra iRepositoryCompra){
        this.iRepositoryCompra = iRepositoryCompra;
    }
    @Override
    public CompraDTO nuevaCompra(CompraDTO compraDTO) {
        ModelMapper modelMapper = new ModelMapper();
        iRepositoryCompra.save(modelMapper.map(compraDTO, Compra.class));
        return compraDTO;
    }

    @Override
    public List<CompraDTO> nuevaCompra(List<CompraDTO> compraDTO) {
        ModelMapper modelMapper = new ModelMapper();
        compraDTO.stream().forEach(e-> iRepositoryCompra.save(modelMapper.map(e, Compra.class)));
        return compraDTO;
    }
}
