package com.JPAHibernateVIVO.MiniSeries.repository;

import com.JPAHibernateVIVO.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
