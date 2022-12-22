package com.example.empleados.service;

import com.example.empleados.dto.request.EmpleadoRequest;
import com.example.empleados.dto.response.EmpleadoResponse;
import com.example.empleados.entity.Empleado;
import com.example.empleados.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final EmpleadoRepository empleadoRepository;


    @Override
    public EmpleadoResponse createEmpleado(EmpleadoRequest request) {

        Empleado empleado = new Empleado();
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setEdad(request.getEdad());
        empleado.setCiudad(request.getCiudad());
        empleado.setProvincia(request.getProvincia());

        Empleado empleadoSaved = empleadoRepository.save(empleado);
        EmpleadoResponse result = new EmpleadoResponse();
        result.setNombre(empleadoSaved.getNombre());
        result.setApellido(empleadoSaved.getApellido());
        result.setEdad(empleadoSaved.getEdad());
        result.setCiudad(empleadoSaved.getCiudad());
        result.setProvincia(empleadoSaved.getProvincia());

        return result;
    }

    @Override
    public EmpleadoResponse updateEmpleado(String id, EmpleadoRequest request) {

        if (empleadoRepository.existsById(id)){

            Empleado empleadoUpdated = new Empleado();
            empleadoUpdated.setId(id);
            empleadoUpdated.setNombre(request.getNombre());
            empleadoUpdated.setApellido(request.getApellido());
            empleadoUpdated.setEdad(request.getEdad());
            empleadoUpdated.setCiudad(request.getCiudad());
            empleadoUpdated.setProvincia(request.getProvincia());

            empleadoRepository.save(empleadoUpdated);
            EmpleadoResponse result = new EmpleadoResponse();
            result.setNombre(empleadoUpdated.getNombre());
            result.setApellido(empleadoUpdated.getApellido());
            result.setEdad(empleadoUpdated.getEdad());
            result.setCiudad(empleadoUpdated.getCiudad());
            result.setProvincia(empleadoUpdated.getProvincia());

            return result;
        }

        return null;
    }

    @Override
    public List<Empleado> getAllEmpleado() {

        return empleadoRepository.findAll();
    }

}
