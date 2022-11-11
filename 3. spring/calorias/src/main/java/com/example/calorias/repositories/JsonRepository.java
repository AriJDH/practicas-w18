package com.example.calorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class JsonRepository<T> implements Repository<T> {
    private String fileName;
    private TypeReference<List<T>> type;

    public JsonRepository(String fileName, TypeReference type){
        this.fileName = fileName;
        this.type = type;
    }

    @Override
    public void add(T t) {
        List<T> list = findAll();
        list.add(t);
        setNewListToFile(list);
    }

    @Override
    public void remove(T t) {
        List<T> list = this.findAll();
        list.remove(t);
        this.setNewListToFile(list);
    }

    @Override
    public void update(T t) {
        List<T> list = this.findAll();
        int index = list.indexOf(t);
        if(index!=-1)
            list.set(index, t);
        this.setNewListToFile(list);
    }

    @Override
    public Optional<T> find(T t) {
        return this.findAll().stream().filter(o->o.equals(t)).findFirst();
    }

    @Override
    public List<T> findAll() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:"+fileName );

        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<T> list = null;
        try {
            list = objectMapper.readValue(file, type);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return list==null?new ArrayList<>():list;
    }

    @Override
    public long count() {
        return this.findAll().size();
    }

    private void setNewListToFile(List<T> list){
        String serializedRepo = new Gson().toJson(list);
        try{
            FileWriter writerObj = new FileWriter(fileName, false);
            writerObj.write(serializedRepo);
            writerObj.close();
        }catch (Exception e){
            throw new RuntimeException("No se pudo encontrar el archivo");
        }
    }

    @Override
    public void removeAll(){
        setNewListToFile(new ArrayList<>());
    }
}
