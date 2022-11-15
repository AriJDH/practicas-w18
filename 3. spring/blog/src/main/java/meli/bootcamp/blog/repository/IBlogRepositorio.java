package meli.bootcamp.blog.repository;

import meli.bootcamp.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepositorio {
    EntradaBlog getEntradaBlogById(int id);
    List<EntradaBlog> getAllEntradaBlog();
    int createEntradaBlog(EntradaBlog e);
}
