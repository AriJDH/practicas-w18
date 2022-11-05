package SaveTheRopa.Clases;

public abstract class Prenda {
    public String marca;
    public String modelo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Prenda(String marca, String modelo) {
        setMarca(marca);
        setModelo(modelo);
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                '}';
    }
}
