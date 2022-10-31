package Producto;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public  Double calcular(int cantidadDeProductos){
        double precioConDescuento=super.calcular(cantidadDeProductos);
        return precioConDescuento;
    }

    @Override
    public String toString() {
        return "NoPrecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
