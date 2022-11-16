package com.link.repository;

import com.link.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    private List<Link> links = new ArrayList<>();

    @Override
    public Link crearLink(Link link) {
        links.add(link);
        return link;
    }

    @Override
    public Integer obtenerEstadisticaLink(Long id) {

        Link link = this.findById(id);

        if (link == null) {
            return null;
        }

        return link.getCantidad();
    }

    public void invalidarLink(Long id) {

        Link link = links.stream().filter(x -> x.getId().equals(id)).findAny().get();

        link.setInvalidado(true);
    }

    @Override
    public Link redireccionarLink(Long id, String password) {

        Link link = links.stream()
                .filter(x -> x.getId().equals(id) && x.getPassword().equals(password))
                .findAny().orElse(null);
        if (link != null){
            link.setCantidad(link.getCantidad() + 1);

        }
        return link;
    }

    @Override
    public Link findById(Long id){
        return links.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }

}
