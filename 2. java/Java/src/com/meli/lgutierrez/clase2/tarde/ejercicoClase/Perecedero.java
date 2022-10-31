package com.meli.lgutierrez.clase2.tarde.ejercicoClase;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadProducto) {
        double reduccion = 0;
        if (diasPorCaducar == 1) {
            reduccion = super.getPrecio() / 4;
        } else if (diasPorCaducar == 2) {
            reduccion = super.getPrecio() / 3;
        } else if (diasPorCaducar == 3) {
            reduccion = super.getPrecio() / 2;
        }
        return super.getPrecio() * cantidadProducto - reduccion;
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
