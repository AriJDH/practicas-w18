package clase3;

import java.util.Comparator;

public class Vehiculo {

    private String modelo;
    private String marca;
    private int costo;
    

    public Vehiculo( String marca, String modelo, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", marca=" + marca + ", costo=" + costo + '}';
    }

}
