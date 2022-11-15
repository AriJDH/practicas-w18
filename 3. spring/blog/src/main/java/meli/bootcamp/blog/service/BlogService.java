package meli.bootcamp.blog.service;

import meli.bootcamp.blog.dto.request.EntradaBlogDto;
import meli.bootcamp.blog.entity.EntradaBlog;
import meli.bootcamp.blog.repository.IBlogRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepositorio blogRepositorio;

    @Override
    public EntradaBlogDto getEntradaBlog(int id) {
        EntradaBlog entrada = blogRepositorio.getEntradaBlogById(id);

        EntradaBlogDto entradaDto = new EntradaBlogDto(entrada.getId(), entrada.getTitulo(),
                entrada.getNombreAutor(), entrada.getFecha());

        return entradaDto;
    }

    @Override
    public List<EntradaBlogDto> getAllEntradaBlog() {
        return blogRepositorio.getAllEntradaBlog().stream().map(e -> new EntradaBlogDto(e.getId(),e.getTitulo(),e.getNombreAutor(),
                e.getFecha())).collect(Collectors.toList());
    }

    @Override
    public int createEntradaBlog(EntradaBlogDto entradaDto) {
        EntradaBlog entrada = new EntradaBlog();
        entrada.setId(entradaDto.getId());
        entrada.setTitulo(entradaDto.getTitulo());
        entrada.setNombreAutor(entradaDto.getNombreAutor());
        entrada.setFecha(entradaDto.getFecha());

        blogRepositorio.createEntradaBlog(entrada);
        return entrada.getId();
    }
}
