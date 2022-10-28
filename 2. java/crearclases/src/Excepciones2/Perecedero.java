package Excepciones2;

import Excepciones2.Producto;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioTotal = cantidadDeProductos * (getPrecio()/getDescuento());
        return precioTotal;
    }


    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    public int getDescuento() {
        if (getDiasPorCaducar() == 1) {
            return 4;
        }
        if (getDiasPorCaducar() == 2) {
            return 3;
        }

        if (getDiasPorCaducar() == 3) {
            return 2;
        }

        return 1;
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
}
