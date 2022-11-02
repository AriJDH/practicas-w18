package Paquete;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    /*@Override  // No es necesario declararlo porque el igual lo hereda
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }*/

    //Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //El toString
    @Override
    public String toString() {
        return "NoPerecedero\n" +
                "tipo=" + tipo + '\n' +
                "nombre=" + nombre + '\n' +
                "precio=" + precio
                ;
    }
}
