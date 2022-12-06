package com.lasperlas.lasperlas.repository;

import com.lasperlas.lasperlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyasRepository extends JpaRepository<Joya,Long> {

}
