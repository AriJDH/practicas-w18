package com.bootcamp.qatester.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TestCase")
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
