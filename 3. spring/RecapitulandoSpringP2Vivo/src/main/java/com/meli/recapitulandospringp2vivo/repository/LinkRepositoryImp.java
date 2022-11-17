package com.meli.recapitulandospringp2vivo.repository;

import com.meli.recapitulandospringp2vivo.dto.request.LinkDTO;
import com.meli.recapitulandospringp2vivo.dto.response.IdLinkDTO;
import com.meli.recapitulandospringp2vivo.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImp implements ILinkRepository{

    private Integer autoincrement=1;
    private List<Link> linkList = new ArrayList<>();

    @Override
    public Link save(Link link) {
        link.setId(autoincrement);
        linkList.add(link);
        autoincrement++;
        return link;
    }

    @Override
    public Link findById(Integer id) {
        return linkList.stream().filter(l-> l.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(Link link) {
        linkList.removeIf(l -> l.getId().equals(link.getId()));
    }
}
