package com.example.joyeria.service;

import com.example.joyeria.dto.ConsultaJoyaOutDTO;
import com.example.joyeria.dto.CreacionJoyaDTO;
import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.ResultadoDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository iJoyaRepository;

    public JoyaService(IJoyaRepository iJoyaRepository) {
        this.iJoyaRepository = iJoyaRepository;
    }

    @Override
    public ResultadoDTO guardarJoya(CreacionJoyaDTO creacionJoyaDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();

        Joya joya = new Joya();
        joya.setMaterial(creacionJoyaDTO.getMaterial());
        joya.setPeso(creacionJoyaDTO.getPeso());
        joya.setNombre(creacionJoyaDTO.getNombre());
        joya.setParticularidad(creacionJoyaDTO.getParticularidad());
        joya.setPosee_pieda(creacionJoyaDTO.getPosee_pieda());
        joya.setVentaONo(creacionJoyaDTO.getVentaONo());

        iJoyaRepository.save(joya);

        resultadoDTO.setMensaje("Creacion exitosa con nro identificacion" + joya.getNro_identificatorio());
        resultadoDTO.setStatus(HttpStatus.OK.value());
        return resultadoDTO;
    }

    @Override
    public ConsultaJoyaOutDTO obtenerJoyas() {

        ConsultaJoyaOutDTO consultaJoyaOutDTO = new ConsultaJoyaOutDTO();

        List<Joya> joyas = iJoyaRepository.findAll();

        List<JoyaDTO> joyaDTOs = joyas.stream()
                .filter(Joya::getVentaONo)
                .map(
                        x -> new JoyaDTO(x.getNro_identificatorio(),
                                x.getNombre(), x.getMaterial(),
                                x.getPeso(), x.getParticularidad(), x.getPosee_pieda(), x.getVentaONo()))
                .collect(Collectors.toList());

        consultaJoyaOutDTO.setJoyaDTOList(joyaDTOs);

        return consultaJoyaOutDTO;
    }

    @Override
    public ResultadoDTO eliminarJoya(Long nroIdentificacion) {

        return null;
    }
}
