package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.AlreadyExistsException;
import com.mercadolibre.linktracker.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LinkRepository implements ILinkRepository{
    private Map<Long, Link> linksDB = new HashMap<>();

    @Override
    public List<Link> getAll() {
        return this.linksDB.entrySet()
                .stream()
                .map(l-> l.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Link findById(Long linkid) {
        return Optional.ofNullable(this.linksDB.get(linkid))
                .orElseThrow(()->new NotFoundException("El link no existe"));
    }

    @Override
    public Integer getMetrics(Long linkid) {
        return this.findById(linkid).getRedirects();
    }

    @Override
    public void invalidate(Long linkid) {
        this.findById(linkid).setEnabled(false);
    }

    @Override
    public Link create(Link link) {
        if(this.linksDB.containsKey(link.getLinkId()))
            throw new AlreadyExistsException("Ya existe un link con ese ID.");
        return this.linksDB.put(link.getLinkId(), link);
    }
}
