package Producto;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public  Double calcular(int cantidadDeProductos){
        double precioConDescuento=super.calcular(cantidadDeProductos);
        switch (diasPorCaducar){
            case 1:
                return precioConDescuento/4;
            case 2:
                return precioConDescuento/2;
            case 3:
                return precioConDescuento/2;
        }
        return precioConDescuento;
    }

    @Override
    public String toString() {
        return "Precedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
