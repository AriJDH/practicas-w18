package com.example.demo.repository;

import com.example.demo.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepository implements EntradaBlogRepositoryI {

    private Map<Long, EntradaBlog> map = new HashMap<>();


    public EntradaBlog nuevoBlog(EntradaBlog entrada) {
        Long newId = entrada.getId();
        this.map.put(newId, entrada);
        return entrada;
    }

    public EntradaBlog findById(Long id) {
        return this.map.get(id);
    }

    public List<EntradaBlog> getBlogs() {
        return this.map.entrySet().stream().map(e -> {
            e.getValue().setId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }

}
