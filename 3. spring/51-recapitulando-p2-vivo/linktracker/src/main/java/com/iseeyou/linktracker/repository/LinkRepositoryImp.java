package com.iseeyou.linktracker.repository;

import com.iseeyou.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImp implements ILinkRepository {
    List<Link> linkList = new ArrayList<>();
    private int linkIdCounter = 0;

    public int getLinkIdCounter() {
        return  linkIdCounter++;
    }

    public LinkRepositoryImp() {
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
                .map(link -> linkList.remove(link))
                .orElse(false);
    }

    private void loadList(){

    }
}
