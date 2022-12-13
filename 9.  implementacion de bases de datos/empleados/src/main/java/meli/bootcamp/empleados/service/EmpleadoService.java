package meli.bootcamp.empleados.service;

import meli.bootcamp.empleados.domain.Empleado;
import meli.bootcamp.empleados.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {
    IEmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void addEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void modifyEmpleado(String id, Empleado empleado) {
        Empleado empleadoToModify = empleadoRepository.findById(id).orElse(null);
        empleadoToModify.setNombre(empleado.getNombre());
        empleadoToModify.setApellido(empleado.getApellido());
        empleadoToModify.setCiudad(empleado.getCiudad());
        empleadoToModify.setEdad(empleado.getEdad());
    }

    @Override
    public List<Empleado> findAllByDescriptionIs(String descripcion) {
        return empleadoRepository.findAllByApellidoIs(descripcion);
    }

    @Override
    public List<Empleado> findAllByDescriptionIn(List<String> descripcion) {
        return empleadoRepository.findAllByApellidoIn(descripcion);
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAllBy();
    }
}
