package com.blog.blog_youtube.service;

import com.blog.blog_youtube.dto.EntradaBlogDTO;
import com.blog.blog_youtube.dto.EntradaBlogInDTO;
import com.blog.blog_youtube.dto.EntradaBlogOutDTO;
import com.blog.blog_youtube.entity.EntradaBlog;
import com.blog.blog_youtube.exception.CreatedException;
import com.blog.blog_youtube.exception.NoFoundException;
import com.blog.blog_youtube.repository.IBlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService {

    private IBlogRepository iBlogRepository;

    public BlogServiceImpl(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public EntradaBlogOutDTO crearBlog(EntradaBlogInDTO entradaBlogInDTO) {

        EntradaBlog entradaBlog = iBlogRepository.consultarBlogPorId(entradaBlogInDTO.getIdBlog());

        if (entradaBlog != null) {
            throw new CreatedException("Ya existe el blog");
        }

        EntradaBlog entradaBlogCrear = new EntradaBlog(entradaBlogInDTO.getIdBlog(), entradaBlogInDTO.getTituloBlog(),
                entradaBlogInDTO.getNombreAutor(), entradaBlogInDTO.getFechaPublicacion());

        Long idBlog = iBlogRepository.crearBlog(entradaBlogCrear);

        return new EntradaBlogOutDTO("Se creo exitosamente", HttpStatus.CREATED.value(), idBlog);
    }

    @Override
    public EntradaBlogDTO consultarBlogPorId(Long id) {

        EntradaBlog entradaBlog = iBlogRepository.consultarBlogPorId(id);

        if (entradaBlog == null) {
            throw new NoFoundException("No se encontro blog");
        }

        return new EntradaBlogDTO(entradaBlog.getIdBlog(), entradaBlog.getTituloBlog(), entradaBlog.getNombreAutor(), entradaBlog.getFechaPublicacion());
    }

    @Override
    public List<EntradaBlogDTO> consultarBlogs() {
        List<EntradaBlog> entradaBlogs = iBlogRepository.consultarBlogs();
        return entradaBlogs.stream().map(x -> new EntradaBlogDTO(x.getIdBlog(), x.getTituloBlog(), x.getNombreAutor(), x.getFechaPublicacion())).collect(Collectors.toList());
    }

}
