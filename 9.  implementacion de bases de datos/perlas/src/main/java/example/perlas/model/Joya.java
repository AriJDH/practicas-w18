package example.perlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue
    private Long  nroIdentificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean venta;

    public Joya() {
    }

    public Joya(Long nroIdentificatorio, String nombre, String material, int peso, String particularidad, boolean posee_piedra, boolean venta) {
        this.nroIdentificatorio = nroIdentificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.venta = venta;
    }
}
