package com.example.qatester.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long id_case;
    private String description;
    private boolean tested;
    private boolean pased;
    @Column(name = "number_of_tries")
    private int number_of_tries;
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate last_update;

    public TestCase() {
    }
}
