public class Vehiculo {

    private String modelo;
    private String marca;
    private int costo;

    public Vehiculo(String marca, String modelo, int costo) {
        this.marca = marca;
        this.modelo = modelo;
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
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getCosto() {
        return this.costo;
    }

    @Override
    public String toString(){
        return "Marca: " + this.marca + "\n" +
                "Modelo: " + this.modelo + "\n" +
                "Costo: " + this.costo + "\n";
    }


}
