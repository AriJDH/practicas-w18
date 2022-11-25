package com.playground.appathlete.repository;

import com.playground.appathlete.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PeopleRepository {

    // Creamos las personas

    Person person1 = new Person("Juan", "Gomez", 27);
    Person person2 = new Person("Pedro", "Ruiz", 29);
    Person person3 = new Person("Luisa", "Mendez", 25);

}
