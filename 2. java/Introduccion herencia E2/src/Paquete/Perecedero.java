package Paquete;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar){
        super(nombre,precio);
        this.diasPorCaducar=diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double finalPrecio = super.calcular(cantidadDeProductos);
        if (diasPorCaducar==1){
            return finalPrecio/4;
        } else {
            if (diasPorCaducar==2){
                return finalPrecio/3;
            }
            else{
                return finalPrecio/2;
            }
        }
    }


    //Getters y setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //el toString

    @Override
    public String toString() {
        return "Perecedero\n" +
                "diasPorCaducar=" + diasPorCaducar + '\n' +
                "nombre=" + nombre + '\n' +
                "precio=" + precio
                ;
    }
}
