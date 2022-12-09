package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.entity.Gem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGemRepository extends JpaRepository<Gem,Long> {
}
