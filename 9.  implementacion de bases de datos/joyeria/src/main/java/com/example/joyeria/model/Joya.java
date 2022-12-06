package model;

import jakarta.persistence.*;

@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    @Column
    private String nombre;
    @Column
    private String material;
    @Column
    private Double peso;
    @Column
    private String particularidad;
    @Column
    private Boolean posee_piedra;
    @Column
    private Boolean ventaONo;
}
