/*Ejercicio 1
Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje
con los atributos id o identificador único y una lista de vehículos. Crea además los constructores de las clases y
los métodos Setter y Getter.
*/
package Ejercicio1Vehiculos.Clases;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Double costo;

    public Vehiculo(String modelo, String marca, Double costo) {
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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
