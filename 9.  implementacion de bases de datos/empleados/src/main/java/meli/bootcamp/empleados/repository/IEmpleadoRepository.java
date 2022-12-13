package meli.bootcamp.empleados.repository;

import meli.bootcamp.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    List<Empleado> findAllByApellidoIs(String apellido);

    List<Empleado> findAllByApellidoIn(List<String> apellido);

    List<Empleado> findAllBy();
}
