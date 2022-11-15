package com.blog.blog.service;

import com.blog.blog.dto.request.EntradaBlogDTOreq;
import com.blog.blog.dto.response.CreacionDTOres;
import com.blog.blog.dto.response.EntradaBlogDTOres;
import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.repository.BlogRepositoryImp;
import com.blog.blog.repository.IblogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImp implements IblogService{
    private final IblogRepository repository;
    public BlogServiceImp(BlogRepositoryImp repo){
        this.repository = repo;
    }

    @Override
    public List<EntradaBlogDTOres> findAll() {

        List<EntradaBlogDTOres> lista = new ArrayList<>();
        for(EntradaBlog e: repository.findAll()){
            EntradaBlogDTOres res = new EntradaBlogDTOres(e.getId(),e.getTituloBlog(),e.getNombreAutor(),e.getFechaPublicacion());
            lista.add(res);
        }
        return lista;
    }

    @Override
    public EntradaBlogDTOres findById(Long id) {

        EntradaBlog e = repository.findById(id);
        EntradaBlogDTOres res = new EntradaBlogDTOres(e.getId(),e.getTituloBlog(),e.getNombreAutor(),e.getFechaPublicacion());

        return res;
    }

    @Override
    public CreacionDTOres addEntradaBlog(EntradaBlogDTOreq entrada) {
        EntradaBlog blog = new EntradaBlog(entrada.getId(), entrada.getTituloBlog(), entrada.getNombreAutor(),entrada.getFechaPublicacion());
        Long res = repository.addEntradaBlog(blog);
        if(res != null)
            return new CreacionDTOres("Se ha creado con exito",blog.getId());

       else return null;
    }
}
