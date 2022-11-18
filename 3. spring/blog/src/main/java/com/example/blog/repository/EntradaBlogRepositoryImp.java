package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.AlreadyExistException;
import com.example.blog.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository{
    Map<Integer, EntradaBlog> entradas = new HashMap<>();

    @Override
    public void createBlog(EntradaBlog entradaBlog) {
        if(entradas.containsKey(entradaBlog.getId())){
            throw new AlreadyExistException("La entrada ya existe");
        }
        entradas.put(entradaBlog.getId(),entradaBlog);

    }

    @Override
    public List<EntradaBlog> findAll() {
        List<EntradaBlog> entradasBlog = entradas.values().stream().collect(Collectors.toList());
        return entradasBlog;
    }

    @Override
    public EntradaBlog findyById(Integer id) {
        if(!entradas.containsKey(id)){
            throw new NotFoundException("Entrada Blog no encontrada");
        }
        return entradas.get(id);
    }
}
