package com.example.qatesters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "testcase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate last_update;
}
