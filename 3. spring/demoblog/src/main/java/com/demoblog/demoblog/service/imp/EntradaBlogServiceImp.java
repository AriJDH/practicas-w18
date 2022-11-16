package com.demoblog.demoblog.service.imp;


import com.demoblog.demoblog.dto.req.EntradaBlogDto;
import com.demoblog.demoblog.dto.res.EntradaBlogIdDto;
import com.demoblog.demoblog.entity.EntradaBlog;
import com.demoblog.demoblog.repository.IEntradaBlogRepository;
import com.demoblog.demoblog.service.IEntradaBlogService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService {

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public EntradaBlogIdDto crearEntradaBlog(EntradaBlogDto entradaBlogDto) {
        EntradaBlog entradaBlog = entradaBlogRepository.crearEntradaBlog(convertToEntity(entradaBlogDto));

        return convertToIdDto(entradaBlog);
    }

    @Override
    public EntradaBlogDto findById(Integer id) {
        return convertToDto(entradaBlogRepository.findById(id));
    }

    private EntradaBlog convertToEntity(EntradaBlogDto entradaBlogDto){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(entradaBlogDto,EntradaBlog.class);
    }
    private EntradaBlogDto convertToDto(EntradaBlog entradaBlog){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(entradaBlog,EntradaBlogDto.class);
    }
    private EntradaBlogIdDto convertToIdDto(EntradaBlog entradaBlog){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(entradaBlog,EntradaBlogIdDto.class);
    }
}
