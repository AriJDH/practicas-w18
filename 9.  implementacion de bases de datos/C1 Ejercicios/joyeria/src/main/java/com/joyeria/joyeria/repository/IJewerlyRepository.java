package com.joyeria.joyeria.repository;

import com.joyeria.joyeria.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
}
