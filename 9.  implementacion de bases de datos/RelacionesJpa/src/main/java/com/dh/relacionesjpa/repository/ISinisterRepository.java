package com.dh.relacionesjpa.repository;

import com.dh.relacionesjpa.model.entity.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinisterRepository extends JpaRepository<Sinister, Integer> {

}
