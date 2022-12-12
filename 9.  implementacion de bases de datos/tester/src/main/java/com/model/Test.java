package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tests")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_case")
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    Integer numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;

}
