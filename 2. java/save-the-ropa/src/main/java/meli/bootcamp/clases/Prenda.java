package meli.bootcamp.clases;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo)
    {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Prenda{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
