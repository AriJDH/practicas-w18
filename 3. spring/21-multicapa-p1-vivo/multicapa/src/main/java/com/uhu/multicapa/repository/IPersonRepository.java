package com.uhu.multicapa.repository;

import com.uhu.multicapa.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> findAll();
}
