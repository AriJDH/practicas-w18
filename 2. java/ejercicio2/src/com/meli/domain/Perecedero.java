package com.meli.domain;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar=diasPorCaducar;
    }

    @Override
    public String toString(){
        return super.toString() + "\nDías por caducar: "+this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad){
        int reduccion;
        switch(this.diasPorCaducar){
            case 0:
                return 0;
            case 1:
                reduccion=4;
                break;
            case 2:
                reduccion=3;
                break;
            case 3:
                reduccion=2;
                break;
            default:
                reduccion=1;
                break;
        }
        return super.calcular(cantidad)/reduccion;
    }
}
