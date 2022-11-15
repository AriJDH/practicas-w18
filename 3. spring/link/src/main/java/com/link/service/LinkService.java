package com.link.service;

import com.link.dto.LinkRequestDTO;
import com.link.dto.LinkResponseEstadisticaDTO;
import com.link.dto.LinkResponseIdDTO;
import com.link.entity.Link;
import com.link.exception.InvalidException;
import com.link.exception.NoFoundException;
import com.link.repository.ILinkRepository;
import org.springframework.stereotype.Service;


@Service
public class LinkService implements ILinkService{

    private final ILinkRepository respository;

    public LinkService(ILinkRepository respository) {
        this.respository = respository;
    }

    private Link LinkRequestDTO2Link(LinkRequestDTO linkRequestDto){

        return new Link(linkRequestDto.getId(), linkRequestDto.getUrl(), linkRequestDto.getPassword(), false, 0);
    }

    private LinkResponseIdDTO Link2LinkResponseIdDTO(Link link){
        return new LinkResponseIdDTO(link.getId(), "Link creado con éxito!");
    }

    private LinkResponseEstadisticaDTO Link2LinkResponseEstadistica(Link link){
        return new LinkResponseEstadisticaDTO(link.getId(), link.getCantidad());
    }

    @Override
    public LinkResponseIdDTO addLink(LinkRequestDTO linkRequestDTO) {
        Link link = LinkRequestDTO2Link(linkRequestDTO);
        Link savedLink = respository.crearLink(link);
        return Link2LinkResponseIdDTO(savedLink);
    }

    @Override
    public LinkResponseIdDTO invalidarLink(Long id){
        Link link = respository.findById(id);
        if (link == null){
            throw new NoFoundException("El link con id " + id + " no existe!");
        }
        respository.invalidarLink(id);
        return new LinkResponseIdDTO(id, "Link invalidado exitosamente");
    }

    @Override
    public LinkResponseEstadisticaDTO obtenerEstadisticas(Long id){
       Integer cant = respository.obtenerEstadisticaLink(id);
        if (cant == null){
            throw new NoFoundException("El link con id " + id + " no existe!");
        }
       return new LinkResponseEstadisticaDTO(id, cant);
    }

    @Override
    public LinkResponseIdDTO redireccionarLink(Long id, String password){
        Link link = respository.redireccionarLink(id, password);
        if (link == null){
            throw new NoFoundException("El link con id " + id + " no existe o el password es incorrecto!");
        }else if(link.getInvalidado()){
            throw new InvalidException("El link con id " + id + " es invalido");
        }

        return new LinkResponseIdDTO(id, "Se redireccionó exitosamente");
    }
}

