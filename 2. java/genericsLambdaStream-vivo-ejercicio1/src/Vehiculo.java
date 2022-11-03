public class Vehiculo implements Comparable<Vehiculo> {
    private String modelo;
    private String marca;
    private int costo;

    public Vehiculo(String modelo, String marca, int costo) {
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "modelo=" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo;
    }

    @Override
    public int compareTo(Vehiculo o) {
        if (this.getMarca().compareTo(o.getMarca()) == 0) {
            return Integer.compare(this.getCosto(), o.getCosto());
        } else {
            return this.getMarca().compareTo(o.getMarca());
        }
    }
}
