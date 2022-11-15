package meli.bootcamp.blog.service;

import meli.bootcamp.blog.dto.request.EntradaBlogDto;
import meli.bootcamp.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    EntradaBlogDto getEntradaBlog(int id);
    List<EntradaBlogDto> getAllEntradaBlog();
    int createEntradaBlog(EntradaBlogDto e);
}
