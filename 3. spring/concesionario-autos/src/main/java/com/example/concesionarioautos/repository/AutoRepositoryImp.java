package com.example.concesionarioautos.repository;

import com.example.concesionarioautos.entity.Auto;
import com.example.concesionarioautos.entity.Service;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AutoRepositoryImp implements IAutoRepository{

    private List<Auto> autoList = new ArrayList<>();
    private Long nextId;

    public AutoRepositoryImp() {
        nextId = 0L;
    }
    @Override
    public void add(Auto auto) {
        autoList.add(auto);
    }

    @Override
    public List<Auto> listAll() {
        return autoList;
    }

    @Override
    public Auto findById(Long id) {
        return autoList.stream().filter(a->a.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Auto> findByYear(int since, int to) {
        return autoList.stream().filter(a-> a.getManufacturingDate().getYear() >= since && a.getManufacturingDate().getYear() <= to).collect(Collectors.toList());
    }

    @Override
    public List<Auto> findeByPrice(Double since, Double to) {
        return autoList.stream().filter(a-> a.getPrice() >= since && a.getPrice() <= to).collect(Collectors.toList());
    }

    @Override
    public Long getNexttId() {
        return ++nextId;
    }
}
