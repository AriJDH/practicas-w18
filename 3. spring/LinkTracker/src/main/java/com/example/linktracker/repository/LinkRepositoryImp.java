package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImp implements ILinkRepository{

    List<Link> linkDB = new ArrayList<>();

    public LinkRepositoryImp(){
        loadList();
    }

    @Override
    public Long createLink(String url) {

        Link link = new Link();
        link.setUrl(url);

        if(linkDB.isEmpty()){
            link.setLinkId(1L);
            
    }else link.setLinkId(linkDB.get(linkDB.size()-1).getLinkId()+1);
        linkDB.add(link);

        return link.getLinkId();


    }

 @Override
 public Link findById(Long linkId){

        return linkDB.stream()
                .filter(l-> l.getLinkId().equals(linkId))
                .findFirst()
                .orElseThrow();
 }

    @Override
    public RedirectView redirect(Long linkId) {
        Link link = this.findById(linkId);
        link.sumarContador();
        return new RedirectView(link.getUrl());
    }



    @Override
    public void deleteLink(Long linkId) {
        Link linkToDelete = linkDB.stream()
                .filter(x -> x.getLinkId().equals(linkId))
                .findFirst()
                .orElse(null);

        linkDB.remove(linkToDelete);
    }

    @Override
    public Integer getMetrics(Long linkId){
        Link link = this.findById(linkId);
        return link.getCountMetrics();
    }

    private void loadList(){
        Link l1 = new Link("123.com",1L);
        Link l2 = new Link("abc.com",2L);
        Link l3 = new Link("qwerty.com",3L);

        linkDB.add(l1);
        linkDB.add(l2);
        linkDB.add(l3);
    }


}
