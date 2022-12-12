package com.joyeria.joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor
public class Jewerly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String material;
    private Integer weight;
    private String characteristic;
    private Boolean hadStone;
    private Boolean saleOrNot;


    public Jewerly() {
        this.saleOrNot = true;
    }

    public boolean isSaleOrNot(){
        return saleOrNot;
    }

}
