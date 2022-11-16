package com.example.blogyoutube.repository;

import com.example.blogyoutube.entity.EntradaBlog;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEntradaBlogRepository {

    public EntradaBlog save(EntradaBlog blog);

    public EntradaBlog findById(Integer id);

    public Map<Integer, EntradaBlog> findAll();
}
