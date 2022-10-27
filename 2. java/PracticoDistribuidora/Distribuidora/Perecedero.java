package Distribuidora;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioBase = super.calcular(cantidadDeProductos);
        double precioFinal = 0;

        switch (this.getDiasPorCaducar()) {
            case 1:
                precioFinal = precioBase / 4;
                break;
            case 2:
                precioFinal = precioBase / 3;
                break;
            case 3:
                precioFinal = precioBase / 2;
                break;
            default:
                precioFinal = precioBase;
                break;
        }
        //System.out.println(precioFinal);
        return precioFinal;
    }
}
