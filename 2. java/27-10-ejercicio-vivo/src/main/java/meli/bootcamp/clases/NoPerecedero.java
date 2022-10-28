package meli.bootcamp.clases;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NoPerecedero{");
        sb.append("tipo='").append(tipo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
