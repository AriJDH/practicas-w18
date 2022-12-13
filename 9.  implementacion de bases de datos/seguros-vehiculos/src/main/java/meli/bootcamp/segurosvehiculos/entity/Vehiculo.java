package meli.bootcamp.segurosvehiculos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate anioFabricacion;
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculos", cascade = CascadeType.ALL)
    private Set<Siniestro> siniestros;
}
