package com.jcundere.ejerciciopractico09.service;

import com.jcundere.ejerciciopractico09.dto.request.LinkRequest;
import com.jcundere.ejerciciopractico09.dto.response.LinkResponse;
import com.jcundere.ejerciciopractico09.entity.LinkEntity;
import com.jcundere.ejerciciopractico09.exception.InvalidCredentialsException;
import com.jcundere.ejerciciopractico09.repository.ILinkRepository;
import com.jcundere.ejerciciopractico09.util.LinkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements ILinkService {

    private final ILinkRepository linkRepository;
    private static Integer idGenerator = 0;


    @Override
    public LinkResponse createLink(LinkRequest request) {

        idGenerator++;
        LinkEntity entity = linkRepository.createEntity(new LinkEntity(idGenerator, request.getUrl(), request.getPassword()));
        return LinkMapper.entity2Response(entity);
    }

    @Override
    public LinkEntity getLinkById(Integer linkId) {

        return linkRepository.getEntityById(linkId);
    }

    @Override
    public String getRedirectByLinkId(Integer linkId, String password) {

        LinkEntity entity = getLinkById(linkId);
        if (entity.getPassword().equals(password)) {
            entity.redirectionSuccess();
            return entity.getUrl();
        } else {
            throw new InvalidCredentialsException("Password Incorrecta !");
        }
    }

    @Override
    public void invalidateLinkById(Integer linkId) {

        getLinkById(linkId).setIsValid(Boolean.FALSE);
    }

}
