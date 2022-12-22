package com.example.qatesters.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "tests")
public class TestCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Boolean tested;

    private Boolean passed;

    private Integer numberOfTries;

    private LocalDate lastUpdate;

}
