package com.example.linktracker.repositories;

import com.example.linktracker.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LinkRepository extends ListRepository<Link>{
    public Optional<Link> findById(long id){
        return super.list.stream().filter(l->l.getId()==id).findFirst();
    }
}
