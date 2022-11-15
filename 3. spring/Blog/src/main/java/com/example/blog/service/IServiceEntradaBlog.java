package com.example.blog.service;

import com.example.blog.dto.request.EntradaBlogRequestDTO;
import com.example.blog.dto.response.EntradaBlogResponseDTO;
import com.example.blog.dto.response.EntradaBlogResponseIdDTO;
import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IServiceEntradaBlog {
    EntradaBlogResponseIdDTO add(EntradaBlogRequestDTO entrada);
    List<EntradaBlogResponseDTO> listAll();
    EntradaBlogResponseDTO findById(Long id);
}
