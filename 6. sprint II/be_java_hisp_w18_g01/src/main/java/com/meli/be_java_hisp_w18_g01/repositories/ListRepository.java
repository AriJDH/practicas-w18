package com.meli.be_java_hisp_w18_g01.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListRepository <T> implements Repository<T>{
    protected List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public void removeAll() {
        this.list.removeAll(this.list);
    }

    @Override
    public void update(T t) {
        int index = list.indexOf(t);
        if(index!=-1)
            list.set(index, t);
    }

    @Override
    public Optional<T> find(T t) {
        return list.stream().filter(o->o.equals(t)).findFirst();
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    @Override
    public long count() {
        return list.size();
    }
}
