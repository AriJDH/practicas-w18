package com.jpaHibernate.miniSeries.repository;

import com.jpaHibernate.miniSeries.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> {
}
