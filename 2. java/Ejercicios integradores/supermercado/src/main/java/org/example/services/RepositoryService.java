package org.example.services;

import org.example.repositories.ListRepository;
import org.example.repositories.RepositoryFactory;

import java.util.List;
import java.util.Optional;

public abstract class RepositoryService<T> {
    private ListRepository<T> listRepository;

    public RepositoryService(ListRepository<T> listRepository) {
        this.listRepository = listRepository;
    }
    public void add(T t){
        listRepository.add(t);
    }
    public void remove(T t){
        listRepository.remove(t);
    }
    public void update(T t){
        listRepository.update(t);
    }
    public Optional<T> find(T t){
       return listRepository.find(t);
    }
    public List<T> findAll(){
        return listRepository.findAll();
    }
    public long count(){
        return listRepository.count();
    }
}
