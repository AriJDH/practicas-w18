package meli.bootcamp.blog.repository;

import meli.bootcamp.blog.entity.EntradaBlog;
import meli.bootcamp.blog.exception.ExceptionConfig;
import meli.bootcamp.blog.exception.ExistBlogException;
import meli.bootcamp.blog.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositorio implements IBlogRepositorio{
    private HashMap<Integer, EntradaBlog> map = new HashMap<Integer, EntradaBlog>();

    @Override
    public EntradaBlog getEntradaBlogById(int id) {
        if(map.get(id) == null)
            throw new NotFoundException("No se encontro Blog con la id " + id);
        return map.get(id);
    }

    @Override
    public List<EntradaBlog> getAllEntradaBlog() {
        List<EntradaBlog> lista = new ArrayList<>();
        for (Map.Entry<Integer, EntradaBlog> entry : map.entrySet()) {
            lista.add(map.get(entry.getKey()));
        }
        return lista;
    }

    @Override
    public int createEntradaBlog(EntradaBlog e) {
        if(map.get(e.getId()) != null)
            throw new ExistBlogException("Existe ya una entrada con la id " + e.getId());

        map.put(e.getId(), e);
        return e.getId();
    }
}
