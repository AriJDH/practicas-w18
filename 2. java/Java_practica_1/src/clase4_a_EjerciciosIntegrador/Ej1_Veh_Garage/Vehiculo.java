package clase4_a_EjerciciosIntegrador.Ej1_Veh_Garage;

public class Vehiculo {
    private String marca;
    private String modelo;
    private Double costo;

    public Vehiculo(String marca, String modelo, Double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", costo=" + costo +
                '}';
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
