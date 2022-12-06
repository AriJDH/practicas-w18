package meli.bootcamp.joyerialasperlas.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@Getter
@Table(name = "joyas")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nro_identificatorio")
    private Long id;
    @Column(name = "nombre")
    private String name;
    private String material;
    @Column(name = "peso")
    private Double weight;
    @Column(name = "particularidad")
    private String notes;
    @Column(name = "posee_piedra")
    private Boolean hasRocks;
    @Column(name = "ventaONo")
    private Boolean onSale;
}
