package com.repository;

import com.entity.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryIMP implements IPersonRepository {
  private final List<Person> people = new ArrayList<Person>();

  public PersonRepositoryIMP() {
    people.add(new Person("Angel", "Torres", 23));
    people.add(new Person("Junior", "Torres", 20));
    people.add(new Person("Milena", "Sandoval", 19));
  }

  @Override
  public List<Person> getPeople() {
    return people;
  }
}
