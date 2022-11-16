package com.example.linktracker.service;

import com.example.linktracker.dto.req.LinkDTOReq;
import com.example.linktracker.dto.resp.LinkCreatedDTOResp;
import com.example.linktracker.dto.resp.LinkDTOResp;
import com.example.linktracker.entity.Link;
import com.example.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LinkServiceImp implements ILinkService{
    @Autowired
    private ILinkRepository repository;


    @Override
    public LinkCreatedDTOResp createLink(LinkDTOReq linkDTOReq, String password) {
        Integer id = repository.createLink(new Link(linkDTOReq.getLink(),password,0,true));
        return new LinkCreatedDTOResp(id);
    }

    @Override
    public LinkDTOResp redirect(Integer id) {
        Link link = repository.getLinkById(id);
        if (link==null){
            throw new RuntimeException("El link no existe");
        }else if (link.getIsValid()){
            repository.countAccessLink(id);
        }
        return new LinkDTOResp(link.getLink(), link.getIsValid());
    }

    @Override
    public Integer countAccessLink(Integer id) {
        return repository.getLinkById(id).getCount();
    }

    @Override
    public void invalidateLink(Integer id) {
        repository.invalidateLink(id);
    }
}
