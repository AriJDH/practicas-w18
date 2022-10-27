package com.meli;

public class Perecedero extends Producto {
    private int diasPorCaducidad;

    public Perecedero(String nombre, double precio, int diasPorCaducidad) {
        super(nombre, precio);
        this.diasPorCaducidad = diasPorCaducidad;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double response = super.calcular(cantidadDeProductos);
        return response / (this.diasPorCaducidad == 1 ? 4 : (this.diasPorCaducidad == 2 ? 3 : (this.diasPorCaducidad == 3 ? 2 : 1)));
    }

    public int getDiasPorCaducidad() {
        return diasPorCaducidad;
    }

    public void setDiasPorCaducidad(int diasPorCaducidad) {
        this.diasPorCaducidad = diasPorCaducidad;
    }

    @Override
    public String toString() {
        return "Perecedero{" + "diasPorCaducidad=" + diasPorCaducidad + '}';
    }
}
