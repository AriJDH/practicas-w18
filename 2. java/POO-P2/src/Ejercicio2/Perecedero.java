package Ejercicio2;
//EJERCICIO 2

// 2.
public class Perecedero extends Producto {
    private int diasPorCadudar;

    public Perecedero(String nombre, double precio, int diasPorCadudar) {
        super(nombre, precio);
        this.diasPorCadudar = diasPorCadudar;
    }

    public int getDiasPorCadudar() {
        return diasPorCadudar;
    }

    public void setDiasPorCadudar(int diasPorCadudar) {
        this.diasPorCadudar = diasPorCadudar;
    }

    @Override
    public String toString() {
        return super.toString()+", dias por cadudar=" + diasPorCadudar;
    }

    /*
    * */
    @Override
    public double calcular(int cantidadDeProductos) {
        double resultado=0;
        if(diasPorCadudar==1)
            resultado=(this.getPrecio()/4)*cantidadDeProductos;
        else{
            if (diasPorCadudar==2)
                resultado=(this.getPrecio()/3)*cantidadDeProductos;
            else {
                if (diasPorCadudar==3)
                    resultado=(this.getPrecio()/2)*cantidadDeProductos;
                else
                    resultado=super.calcular(cantidadDeProductos);
            }
        }
        return resultado;
    }
}
