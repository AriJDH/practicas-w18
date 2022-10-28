package com.main;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantProductos) {

        double result = super.calcular(cantProductos);

        switch (this.diasPorCaducar){
            case 1:
                result = result / 4;
                break;
            case 2:
                result = result / 3;
                break;
            case 3:
                result = result / 2;
        }

        return result;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

}
