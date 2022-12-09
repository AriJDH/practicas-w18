package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.request.CreateJewelRequestDto;
import com.example.joyerialasperlas.dto.response.JewelResponseDto;
import com.example.joyerialasperlas.dto.response.JewelDto;
import com.example.joyerialasperlas.entity.Jewel;
import com.example.joyerialasperlas.repository.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class JewelServiceImp implements IJewelService{

    @Autowired
    IJewelRepository jewelRepository;

    @Override
    public JewelResponseDto createJewel(CreateJewelRequestDto jewel) {
        //ver el mapping, por el momento lo voy a hacer manual.
        Jewel jewelToCreate = new Jewel();
        jewelToCreate.setNombre(jewel.getNombre());
        jewelToCreate.setMaterial(jewel.getMaterial());
        jewelToCreate.setPrecio(jewel.getPrecio());
        jewelToCreate.setParticularidad(jewel.getParticularidad());
        jewelToCreate.setPosee_piedra(jewel.isPosee_piedra());
        jewelToCreate.setVentaONo(jewel.isVentaONo());

        jewelRepository.save(jewelToCreate);
        return new JewelResponseDto("Joya creada",200);
    }

    @Override
    public List<JewelDto> getJewels() {
        List<Jewel> jewels = jewelRepository.findAll().stream().filter(jewel -> jewel.isVentaONo() == true).collect(Collectors.toList());
        //Cambiar por mapping
        List<JewelDto> jewelDtos = new ArrayList<>();
        for (Jewel jewel: jewels){
            JewelDto jewelCreated = new JewelDto();
            jewelCreated.setNombre(jewel.getNombre());
            jewelCreated.setMaterial(jewel.getMaterial());
            jewelCreated.setPrecio(jewel.getPrecio());
            jewelCreated.setParticularidad(jewel.getParticularidad());
            jewelCreated.setPosee_piedra(jewel.isPosee_piedra());
            jewelCreated.setVentaONo(jewel.isVentaONo());
            jewelDtos.add(jewelCreated);
        }
        return jewelDtos;
    }

    @Override
    public JewelResponseDto deleteJewel(Long id) {
        Jewel jewel = jewelRepository.findById(id).get();
        jewel.setVentaONo(false);
        jewelRepository.save(jewel);
        return new JewelResponseDto("joya eliminada correctamente",200);
    }

    @Override
        public CreateJewelRequestDto updateJewel(Long id, CreateJewelRequestDto updateJewel) {
        Jewel jewel = jewelRepository.findById(id).get();
        jewel.setNombre(updateJewel.getNombre());
        jewel.setMaterial(updateJewel.getMaterial());
        jewel.setPrecio(updateJewel.getPrecio());
        jewel.setParticularidad(updateJewel.getParticularidad());
        jewel.setPosee_piedra(updateJewel.isPosee_piedra());
        jewel.setVentaONo(updateJewel.isVentaONo());
        jewelRepository.save(jewel);
        return updateJewel;
    }
}
