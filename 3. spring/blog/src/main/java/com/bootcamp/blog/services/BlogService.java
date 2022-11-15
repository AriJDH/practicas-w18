package com.bootcamp.blog.services;

import com.bootcamp.blog.dto.request.BlogDtoRequest;
import com.bootcamp.blog.dto.response.BlogDtoResponse;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public void creaBlog(BlogDtoRequest blogDtoRequest) {
            EntradaBlog entradaBlog = mapper.convertValue(blogDtoRequest, EntradaBlog.class);
            blogRepository.addBlog(entradaBlog);
    }
    @Override
    public Boolean existeId(Integer idBlog){
        boolean resp= false;
        for (EntradaBlog blog:blogRepository.getAllBlogs())
        {
            if (blog.getId()==idBlog){
                resp=true;
            }
        }
        return resp;
    }

    public List<BlogDtoResponse> findById(Integer id){
        List<BlogDtoResponse> blogReponseList = blogRepository.findById(id).stream()
                .map(p-> BlogDtoResponse.builder().id(p.getId()).titulo(p.getTitulo()).autor(p.getAutor()).fechaPublicacion(p.getFechaPublicacion()).build())
                .collect(Collectors.toList());
        return blogReponseList;

    }
    @Override
    public List<BlogDtoResponse> getAllBlog(){
        return blogRepository.getAllBlogs().stream()
                .map(p-> BlogDtoResponse.builder().id(p.getId()).titulo(p.getTitulo()).autor(p.getAutor()).fechaPublicacion(p.getFechaPublicacion()).build())
                .collect(Collectors.toList());
    }
}
