package clase2;

public class NoPerecedero extends Producto{
    private String tipo;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "NoPerecedero{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
