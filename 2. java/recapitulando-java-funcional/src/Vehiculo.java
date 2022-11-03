public class Vehiculo {
    private String model;
    private String marca;
    private double costo;

    public Vehiculo(String model, String marca, double costo) {
        this.model = model;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModel() {
        return model;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
