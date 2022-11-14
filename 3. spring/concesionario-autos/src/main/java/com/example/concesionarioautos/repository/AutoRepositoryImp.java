package com.example.concesionarioautos.repository;

import com.example.concesionarioautos.entity.Auto;
import org.springframework.stereotype.Repository;


import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AutoRepositoryImp implements IAutoRepository{

    private Map<Long, Auto> autoMap = new HashMap<>();
    private Long id;

    public AutoRepositoryImp() {
        id = 0L;
    }
    @Override
    public void add(Auto auto) {
        autoMap.put(id++, auto);
    }

    @Override
    public List<Auto> listAll() {
        return autoMap.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
    }

    @Override
    public Auto findById(Long id) {
        return autoMap.get(id);
    }

    @Override
    public List<Auto> findByYear(int since, int to) {
        return autoMap.entrySet().stream().map(x->x.getValue()).filter(a-> a.getManufacturingDate().getYear() >= since && a.getManufacturingDate().getYear() <= to).collect(Collectors.toList());
    }

    @Override
    public List<Auto> findeByPrice(Double since, Double to) {
        return autoMap.entrySet().stream().map(x->x.getValue()).filter(a-> a.getPrice() >= since && a.getPrice() <= to).collect(Collectors.toList());
    }

}
