package com.demolinks.demolinks.repository.Imp;

import com.demolinks.demolinks.entity.Link;
import com.demolinks.demolinks.repository.ILinkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LinkRepositoryImp implements ILinkRepository {

    List<Link> linkList = new ArrayList<>();
    public LinkRepositoryImp(){
        loadList();
    }
    @Override
    public Boolean createLink(Link link) {
        return linkList.add(link);
    }

    @Override
    public Optional<Link> findLink(Integer linkId) {

        return linkList.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst();
    }

    @Override
    public Boolean removeLink(Integer linkId) {
        return findLink(linkId)
                .map(link-> linkList.remove(link))
                .orElse(false);
    }

    private void loadList(){

    }
}
