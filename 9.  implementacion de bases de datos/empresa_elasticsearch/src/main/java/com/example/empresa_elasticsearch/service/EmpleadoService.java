package com.example.empresa_elasticsearch.service;

import com.example.empresa_elasticsearch.domain.Empleado;
import com.example.empresa_elasticsearch.dto.CreacionEmpleadoDTO;
import com.example.empresa_elasticsearch.dto.ModificacionEmpleadoDTO;
import com.example.empresa_elasticsearch.repository.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final ModelMapper modelMapper = new ModelMapper();

    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public String crearEmpleado(CreacionEmpleadoDTO creacionEmpleadoDTO) {

        Empleado empleado = modelMapper.map(creacionEmpleadoDTO, Empleado.class);

        this.empleadoRepository.save(empleado);

        return "creado";
    }

    public String modificarEmpleado(ModificacionEmpleadoDTO modificacionEmpleadoDTO) {

        Optional<Empleado> empleadoOptional = this.empleadoRepository.findById(modificacionEmpleadoDTO.getId());

        if (empleadoOptional.isEmpty()) {
            return "NO EXISTE";
        }

        Empleado empleado = modelMapper.map(modificacionEmpleadoDTO, Empleado.class);

        this.empleadoRepository.save(empleado);

        return "Modificado exitosamente";
    }

}
