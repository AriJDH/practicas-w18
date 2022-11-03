public class Vehiculo {
    String modelo;
    String marca;
    double costo;

    //Constructor
    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    //Getters and Setters
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
        return "Vehiculo : " +
                "Modelo='" + modelo + '\'' +
                "-Marca='" + marca + '\'' +
                "-Costo=" + costo ;

    }
}
