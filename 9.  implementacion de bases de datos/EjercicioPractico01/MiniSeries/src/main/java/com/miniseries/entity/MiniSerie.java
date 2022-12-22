package com.miniseries.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "miniserie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;

}
