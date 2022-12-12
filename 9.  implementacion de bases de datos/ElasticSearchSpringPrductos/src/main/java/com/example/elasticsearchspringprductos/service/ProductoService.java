package com.example.elasticsearchspringprductos.service;

import com.example.elasticsearchspringprductos.domain.Productos;
import com.example.elasticsearchspringprductos.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository repo;

    public Productos save(Productos productos){
        return repo.save(productos);
    }

    public List<Productos> findAll(){
        List<Productos> result = new ArrayList<>();
        Iterable<Productos> iterable = repo.findAll();
        iterable.forEach(p -> result.add(p));
        return result;
    }

    public Productos update(Productos productos){
        return repo.save(productos);
    }
}
