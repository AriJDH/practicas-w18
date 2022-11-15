package com.myspace.blog.repository;

import com.myspace.blog.entity.EntradaBlog;
import com.myspace.blog.exception.IdNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository{

    List<EntradaBlog> entradaBlogList;

    public BlogRepository(List<EntradaBlog> entradaBlogList) {

        this.entradaBlogList = entradaBlogList;

        loadList();
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradaBlogList;
    }

    @Override
    public Boolean addBlog(EntradaBlog entradaBlog) {
        for (EntradaBlog blog : entradaBlogList) {
            if (blog.getId() == entradaBlog.getId()) {
                return false;
            }
        }
        entradaBlogList.add(entradaBlog);
        return true;
    }

    @Override
    public EntradaBlog getBlogById(int id) {
        Optional<EntradaBlog> entradaBlog = entradaBlogList.stream()
                .filter(entradaBlog1 -> entradaBlog1.getId() == id)
                .findFirst();
        if (entradaBlog.isPresent()) {
            return  entradaBlog.get();
        } else {
            throw new IdNotFoundException("id not found");
        }
    }

    private void loadList() {
        entradaBlogList.add(new EntradaBlog(1, "Frutas", "Fulano", "2022-06-10"));
        entradaBlogList.add(new EntradaBlog(2, "Verduras", "Mengano", "2022-07-10"));
        entradaBlogList.add(new EntradaBlog(3, "Carnes", "Mumino", "2022-08-10"));
    }


}
