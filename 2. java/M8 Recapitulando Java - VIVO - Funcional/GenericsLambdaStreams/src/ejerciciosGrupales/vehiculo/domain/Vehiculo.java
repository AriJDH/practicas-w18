package ejerciciosGrupales.vehiculo.domain;

import java.util.Objects;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Integer costo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, Integer costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return modelo.equals(vehiculo.modelo) && marca.equals(vehiculo.marca) && costo.equals(vehiculo.costo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, costo);
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + " \t" +
                "Marca: " + marca + ' ' +
                "\t $ " + costo;
    }
}
