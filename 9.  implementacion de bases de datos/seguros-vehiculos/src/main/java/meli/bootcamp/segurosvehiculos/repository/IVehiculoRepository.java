package meli.bootcamp.segurosvehiculos.repository;

import meli.bootcamp.segurosvehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente " +
            "FROM Vehiculo v")
    List<String> findByPatente();

    @Query("SELECT v.patente, v.marca " +
            "FROM Vehiculo v " +
            "ORDER BY v.anioFabricacion")
    List<Vehiculo> findByPatenteAndMarcaOrderByAnioFabricacion();

    // TODO:
    @Query("SELECT v.patente " +
            "FROM Vehiculo v ")
    List<String> findByPatenteGreaterThanEqualCuatroRuedas();

    @Query("SELECT v.patente, v.marca, v.modelo " +
            "FROM Vehiculo v " +
            "INNER JOIN Siniestro s " +
            "ON v.id = s.vehiculo.id " +
            "WHERE s.perdidaEconomica > 10000")
    List<String[]> findByPatenteAndMarcaAndModeloAndPerdidaEconomicaGreaterThanTenThousand();

    @Query
    List<Vehiculo> findMatriculaAndMarcaAndModeloAndTotalPerdidaGreaterThanTenThousand();
}
