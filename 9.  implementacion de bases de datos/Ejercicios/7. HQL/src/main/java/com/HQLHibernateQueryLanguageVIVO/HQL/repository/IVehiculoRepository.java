package com.HQLHibernateQueryLanguageVIVO.HQL.repository;

import com.HQLHibernateQueryLanguageVIVO.HQL.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
	
	// TODO continuar desarrollo
	// Listado de patentes de todos los vehiculos registrados
	
	// Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
	
	// Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el
	
	// corriente año.
	
	// Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
	
	// Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.



}
