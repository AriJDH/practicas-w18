package com.spring.blog.repository;

import com.spring.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BlogRepository implements IBlogRepository {
    private Map<Integer, EntradaBlog> entries = new HashMap<>();
    private Integer id;

    public BlogRepository() {
        this.id = 1;
    }

    @Override
    public Integer addEntry(EntradaBlog entry) {
        Integer entryId = id;
        EntradaBlog newEntry = new EntradaBlog(entryId, entry);
        entries.put(entryId, newEntry);
        id++;
        return entryId;
    }

    @Override
    public List<EntradaBlog> getAllEntries() {
        return entries.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public EntradaBlog getEntryById(Integer id) {
        Optional<EntradaBlog> optional = entries.entrySet().stream()
                .filter(x -> x.getKey() == id)
                .map(x -> x.getValue())
                .findFirst();

        return optional.isPresent() ? optional.get() : null;
    }
}
