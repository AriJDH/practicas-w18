package com.example.empleados.service;

import com.example.empleados.domain.Empleado;
import com.example.empleados.repository.IEmpleadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImp implements IEmpleadoService{

    IEmpleadoRepository empleadoRepository;

    public EmpleadoServiceImp(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> empleadoList = new ArrayList<>();
        Iterable<Empleado> empleadoIterable = empleadoRepository.findAll();
        empleadoIterable.forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    @Override
    public Empleado findById(String id) {
        return empleadoRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"El Empleado "+id+" no existe"));
    }

    @Override
    public Empleado update(String id, Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteById(String id) {
        if (findById(id)!=null){
            empleadoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El empleado "+id+" no existe");
        }

    }
}
