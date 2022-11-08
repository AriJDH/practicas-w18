package Distribuidora;

public class Perecederos extends Producto {
    private int diasPorCaducar;
    public Perecederos(String nombre, double precio, int diasPorCaducar) {
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
        return "Perecederos{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double resultado = cantidadDeProductos*precio;
        double precioFinal;
        System.out.println(resultado);
        if (diasPorCaducar == 1) {
            precioFinal =precio-(precio/4);
        }else if(diasPorCaducar == 2) {
            precioFinal =precio-(precio/3);
        }else {
            precioFinal =precio-(precio/2);
        }
        return precioFinal;
    }
}
