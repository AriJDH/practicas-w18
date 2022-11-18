package com.example.blog.repositories;

import com.example.blog.entities.Blog;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BlogRepository extends ListRepository<Blog>{
    public Optional<Blog> findById(long id){
        return super.list.stream().filter(b->b.getId()==id).findFirst();
    }
}
