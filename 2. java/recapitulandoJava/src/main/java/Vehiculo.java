public class Vehiculo {
    private String modelo;
    private String marca;
    private float costo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, float costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return " Vehiculo { " +
                "modelo: " + modelo  +
                " - marca: " + marca +
                " - costo: " + costo+" }" ;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
