package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BlogRepositoryImp implements IblogRepository{

    List<EntradaBlog> entradas;

    public BlogRepositoryImp(){
       this.entradas = new ArrayList<>();
        LocalDate date = LocalDate.parse("1990-12-12");
        EntradaBlog e1= new EntradaBlog(1L,"Titulo1","Autor1", date);
        EntradaBlog e2= new EntradaBlog(2L,"Titulo2","Autor2", date.plusDays(45756));
        EntradaBlog e3= new EntradaBlog(3L,"Titulo3","Autor3", date.minusDays(12345));
        EntradaBlog e4= new EntradaBlog(4L,"Titulo4","Autor1", date.plusDays(234));
        this.entradas.add(e1);
        this.entradas.add(e2);
        this.entradas.add(e3);
        this.entradas.add(e4);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradas;
    }

    @Override
    public EntradaBlog findById(Long id) {
        for(EntradaBlog e:entradas){
            if(e.getId().equals(id))
                return e;
        }
        return null;
    }

    @Override
    public Long addEntradaBlog(EntradaBlog entrada) {

        if(findById(entrada.getId())==null){
            entradas.add(entrada);
            return entrada.getId();
        }
        else
            return null;
    }
}
