package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaDtoReq;
import com.example.joyeria.dto.response.JoyaDtoRsp;
import com.example.joyeria.entity.Joya;
import com.example.joyeria.exception.BadRequestException;
import com.example.joyeria.exception.NotFoundException;
import com.example.joyeria.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService{

    private final IJoyaRepository joyaRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Long saveJoya(JoyaDtoReq joyaDto) {
        Joya joya;
        try {
            joya = mapper.convertValue(joyaDto, Joya.class);
            joyaRepository.save(joya);
        }catch (Exception e){
            throw new BadRequestException("Hubo un problema con la creación de la joya, por favor intenta nuevamente.");
        }
        return joya.getId();
    }

    @Override
    public List<JoyaDtoRsp> getJoyas() {
        List<Joya> joyas = joyaRepository.findAll().stream().filter(j -> j.getVentaONo() == true).collect(Collectors.toList());
        List<JoyaDtoRsp> respuesta = joyas.stream().map(j -> mapper.convertValue(j, JoyaDtoRsp.class)).collect(Collectors.toList());
        return respuesta;
    }

    @Override
    public void deleteJoya(Long id) {
        JoyaDtoRsp joya = findJoya(id);
        joya.setVentaONo("false");
        saveJoya(mapper.convertValue(joya, JoyaDtoReq.class));
    }

    @Override
    public JoyaDtoRsp findJoya(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isEmpty()){
            throw new NotFoundException("El id:" + id + " no fue encontrado en la base de datos. Por favor intenta nuevamente.");
        }
        JoyaDtoRsp joyaRespuesta = new JoyaDtoRsp(
                joya.get().getId(),
                joya.get().getNombre(),
                joya.get().getMaterial(),
                joya.get().getPeso().toString(),
                joya.get().getParticularidad(),
                joya.get().getPoseePiedra().toString(),
                joya.get().getVentaONo().toString()
        );
        return joyaRespuesta;
    }
    @Override
    public JoyaDtoRsp modifyJoya(Long id, JoyaDtoReq joya){
        //Verifico que exista
        JoyaDtoRsp joyaAModificar = findJoya(id);
        //Modifico la joya
        joyaAModificar.setNombre(joya.getNombre());
        joyaAModificar.setMaterial(joya.getMaterial());
        joyaAModificar.setPeso(joya.getPeso());
        joyaAModificar.setParticularidad(joya.getParticularidad());
        joyaAModificar.setPoseePiedra(joya.getPoseePiedra());
        joyaAModificar.setVentaONo(joya.getVentaONo());
        //Guardo la joya
        saveJoya(joya);
        //Retorno la joya
        return joyaAModificar;
    }
}
