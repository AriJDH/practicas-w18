package com.link.linksproject.repository;

import com.link.linksproject.entity.LinkEntity;
import com.link.linksproject.excepciones.NotFoundLinkException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepo implements ILinkRepo{

    HashMap<Integer,LinkEntity> listaLink = new HashMap<>();
    private int idAutoGenerado = 1;

    @Override
    public int createLink(LinkEntity link) {
        link.setId(idAutoGenerado);
        listaLink.put(idAutoGenerado,link);
        ++idAutoGenerado;
        return link.getId();
    }

    @Override
    public void invalidateLink(int id) {
        if(listaLink.get(id) != null){
            listaLink.get(id).setHabilitado(false);
        }

    }

    @Override
    public LinkEntity getLinkById(int id) {
        if(listaLink.get(id) != null){
            return listaLink.get(id);
        }
        throw new NotFoundLinkException("No existe Link con la id " + id);
    }
}
