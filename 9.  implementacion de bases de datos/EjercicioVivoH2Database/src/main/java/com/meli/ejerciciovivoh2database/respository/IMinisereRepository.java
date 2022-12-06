package com.meli.ejerciciovivoh2database.respository;

import com.meli.ejerciciovivoh2database.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMinisereRepository extends JpaRepository<Miniserie,Long> {
}
