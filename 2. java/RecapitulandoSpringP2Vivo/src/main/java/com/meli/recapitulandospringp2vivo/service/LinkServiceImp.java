package com.meli.recapitulandospringp2vivo.service;

import com.meli.recapitulandospringp2vivo.dto.request.CreateLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.IdLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.InvalidateLinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.MetricDTO;
import com.meli.recapitulandospringp2vivo.entity.Link;
import com.meli.recapitulandospringp2vivo.exception.LinkNotFound;
import com.meli.recapitulandospringp2vivo.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService {

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public IdLinkDTO create(CreateLinkDTO createLinkDTO) {
        var link = iLinkRepository.save(
                new Link(createLinkDTO.getLink(), createLinkDTO.getPassword())
        );
        return new IdLinkDTO(link.getId());
    }

    @Override
    public String redirect(Integer id,String password) {
        var link = iLinkRepository.findById(id);
        if (link==null) throw new LinkNotFound("El link con id:" +id+" no existe.");
        if (!link.getPassword().equals(password)) throw new LinkNotFound("Password erronea.");
        link.increaseView();
        return link.getLink();
    }

    @Override
    public MetricDTO getMetrics(Integer id) {
        var link = iLinkRepository.findById(id);
        if (link==null) throw new LinkNotFound("El link con id:" +id+" no existe.");
        return new MetricDTO(link.getId(),link.getCount());
    }

    @Override
    public InvalidateLinkDTO invalidateLink(Integer id) {
        var link = iLinkRepository.findById(id);
        if (link==null) throw new LinkNotFound("El link con id:" +id+" no existe.");
        iLinkRepository.delete(link);
        return new InvalidateLinkDTO(link.getId(),link.getLink(),"Link invaldiado, no puedes volver a usarlo.");
    }
}
