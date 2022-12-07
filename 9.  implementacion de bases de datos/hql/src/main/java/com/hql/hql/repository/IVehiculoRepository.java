package com.hql.hql.repository;

import com.hql.hql.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> findPatentes();

    @Query("from Vehiculo v order by v.añoFabricacion DESC ")
    List<Vehiculo> findByAñoDeFabricacion();

}
