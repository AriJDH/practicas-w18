package com.repository;

import com.entity.Sport;
import java.util.List;
import java.util.Optional;

public interface ISportRepository {
  List<Sport> getSports();
//   Optional<T> getSport(String name);
}
