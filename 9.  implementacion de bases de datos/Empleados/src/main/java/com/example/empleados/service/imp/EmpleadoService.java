package com.example.empleados.service.imp;

import com.example.empleados.domain.Empleado;
import com.example.empleados.dto.EmpleadoDto;
import com.example.empleados.dto.Response;
import com.example.empleados.repository.IEmpleadoRepository;
import com.example.empleados.service.IEmpleadoService;
import static com.example.empleados.util.Converter.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    private IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Response create(EmpleadoDto empleadoDto) {
        Empleado empleado = empleadoRepository.save(toEntity(empleadoDto));
        return new Response(toDto(empleado), "Save Success", 200);
    }

    @Override
    public Response update(EmpleadoDto empleadoDto) {
        findById(empleadoDto.getId());
        Empleado empleado = empleadoRepository.save(toEntity(empleadoDto));
        return new Response(toDto(empleado), "Save Success", 200);
    }

    @Override
    public List<EmpleadoDto> findAll() {
        List<Empleado> empleados = new ArrayList<>();
        List<EmpleadoDto> empleadosDto = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleados::add);
        empleados.stream().forEach(e -> empleadosDto.add(toDto(e)));
        return empleadosDto;
    }

    @Override
    public EmpleadoDto findById(String id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return mapper.map(empleado, EmpleadoDto.class);
    }
}
