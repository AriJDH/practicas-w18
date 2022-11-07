package vehiculos;

public class Vehiculo {
    String modelo;
    String marca;
    double costo;

    public Vehiculo(String marca, String modelo,  double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toString(){
        return "Marca: ,"+marca+", Modelo: "+modelo+", Costo: "+costo;
    }
}
