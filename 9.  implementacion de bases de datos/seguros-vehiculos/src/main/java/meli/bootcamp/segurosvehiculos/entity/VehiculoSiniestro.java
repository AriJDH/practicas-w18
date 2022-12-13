package meli.bootcamp.segurosvehiculos.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehiculoSiniestro {
    private Vehiculo vehiculo;
    private Integer cantidadTotal;
}
