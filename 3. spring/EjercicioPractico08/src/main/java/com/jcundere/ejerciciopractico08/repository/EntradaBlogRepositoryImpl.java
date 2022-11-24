package com.jcundere.ejerciciopractico08.repository;

import com.jcundere.ejerciciopractico08.entity.EntradaBlog;
import com.jcundere.ejerciciopractico08.exception.RepeatedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository {

    Map<Integer, EntradaBlog> entradaBlogMap = new HashMap<>();


    @Override
    public EntradaBlog createEntity(EntradaBlog entradaBlog) {

        if (entradaBlogMap.containsKey(entradaBlog.getId())) {
            throw new RepeatedException("La Entrada de Blog con ID: " + entradaBlog.getId() + " Ya Existe !");
        }

        this.entradaBlogMap.put(entradaBlog.getId(), entradaBlog);
        return entradaBlog;
    }

    @Override
    public EntradaBlog getEntityById(Integer id) {

        return entradaBlogMap.get(id);
    }

    @Override
    public List<EntradaBlog> getAllEntity() {

        return new ArrayList<>(entradaBlogMap.values());
    }

}
