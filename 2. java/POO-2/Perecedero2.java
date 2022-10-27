package com.company;

public class Perecedero2 extends Producto{
    public int diasPorCaducar;



    public Perecedero2(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero2(){}
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero2{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProducto){
        double precio = super.calcular(cantidadDeProducto);
        switch(diasPorCaducar){
            case 1:
                return precio/4;
            case 2:
                return precio/3;
            case 3:
                return precio/2;
            default:
                return precio;
        }
    }
}
