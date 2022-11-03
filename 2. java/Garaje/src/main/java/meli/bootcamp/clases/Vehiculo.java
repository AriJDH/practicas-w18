package meli.bootcamp.clases;

public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String modelo, String marca, double costo) {
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehiculo{");
        sb.append("modelo='").append(modelo).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", costo=").append(costo);
        sb.append('}');
        return sb.toString();
    }
}
