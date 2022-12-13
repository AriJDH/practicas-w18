package com.vroom.autos.repository;

import com.vroom.autos.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select v.licensePlate from Vehicle v")
    List<String> findAllLicensePlate();

    @Query("from Vehicle v order by v.fabricationYear")
    List<Vehicle> findAllOrderByFabricationYear();

    @Query("from Vehicle v " +
            "where v.wheelCount > :wheelCountGreaterThan " +
            "and v.fabricationYear = :year")
    List<Vehicle> findByWheelCountGreaterThanAndFabricationYearIs(
            @Param("wheelCountGreaterThan") Integer wheelCountGreaterThan,
            @Param("year") Integer year);

    @Query("from Vehicle v " +
            "join v.accidentList as a " +
            "where a.monetaryLoss > :monetaryLossGreaterThan")
    List<Vehicle> findVehicleByAccidentMonetaryLossGreaterThan(
            @Param("monetaryLossGreaterThan") Double monetaryLossGreaterThan);
}
