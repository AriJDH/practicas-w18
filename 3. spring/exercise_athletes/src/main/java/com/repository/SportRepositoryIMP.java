package com.repository;

import com.entity.Sport;
import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class SportRepositoryIMP implements ISportRepository {
  private final List<Sport> sports = new ArrayList<Sport>();

  public SportRepositoryIMP() {
    sports.add(new Sport("Soccer", "Noob"));
    sports.add(new Sport("Bascketball", "Professional"));
  }

  @Override
  public List<Sport> getSports() {
    return sports;
  }
  //   @Override
  //   public Optional getSport(String name) {
  //     // TODO Auto-generated method stub
  //     return null;
  //   }

  //   @Override
  //   public Sport getSport(String name) {
  //     return sports.stream()
  //     .filter(sport -> sport.getNombre().equals(name))
  //     .collect(Collectors.toList());
}
