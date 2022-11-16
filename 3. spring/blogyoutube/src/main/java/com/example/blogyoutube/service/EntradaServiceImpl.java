package com.example.blogyoutube.service;

import com.example.blogyoutube.dto.request.EntradaBlogDtoReq;
import com.example.blogyoutube.dto.response.EntradaBlogMessage;
import com.example.blogyoutube.dto.response.EntradaBlogRes;
import com.example.blogyoutube.entity.EntradaBlog;
import com.example.blogyoutube.exception.BadRequestExcepction;
import com.example.blogyoutube.exception.NotFoundException;
import com.example.blogyoutube.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntradaServiceImpl implements IEntradaBlogService{

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;

    @Override
    public EntradaBlogMessage save(EntradaBlogDtoReq blogDto) {
        if (blogDto.getTitulo() == null){
            throw new BadRequestExcepction("El blog no pudo ser registrado, debe ingresar al menos un título.");
        } else {
            LocalDate hoy = LocalDate.now();
            EntradaBlog blogEntity = new EntradaBlog(blogDto.getTitulo(), blogDto.getAutor(), hoy);
            EntradaBlog blogRespuesta = entradaBlogRepository.save(blogEntity);
            System.out.println(blogRespuesta.toString());
            return new EntradaBlogMessage("El blog con id: " + blogRespuesta.getId() + " fue registrado con éxito.");
        }
    }

    @Override
    public EntradaBlogRes findById(Integer id) {
        EntradaBlog entradaEntity = entradaBlogRepository.findById(id);

        if (entradaEntity == null){
            throw new NotFoundException("El blogo con el id: " + id + " no fue encontrado.");
        } else {
            EntradaBlogRes blogRespuesta = new EntradaBlogRes(
                    entradaEntity.getId(), entradaEntity.getTitulo(), entradaEntity.getAutor(), entradaEntity.getFechaPublicacion());
            return blogRespuesta;
        }
    }

    @Override
    public Map<Integer, EntradaBlogRes> findAll() {
        Map<Integer, EntradaBlog> blogsEntity = entradaBlogRepository.findAll();

        if (blogsEntity.isEmpty()){
            throw new NotFoundException("No hay blogs registrados");
        } else{
            Map<Integer, EntradaBlogRes> blogsRespuesta = new HashMap<>();
            for (Map.Entry<Integer, EntradaBlog> entry: blogsEntity.entrySet() ) {
                blogsRespuesta.put(entry.getKey(), new EntradaBlogRes(
                        entry.getValue().getId(),
                        entry.getValue().getTitulo(),
                        entry.getValue().getAutor(),
                        entry.getValue().getFechaPublicacion()
                        ));
            }
            return blogsRespuesta;
        }

    }
}
