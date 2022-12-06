package com.example.demo.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class MiniSerie {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String name;
    private Double rating;
    private Integer amountOfAwards;

}
