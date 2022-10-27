package Poo;

public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        setDiasPorCaducar(diasPorCaducar);
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double calculo = 0;

        calculo = super.calcular(cantidadDeProductos);

        if (getDiasPorCaducar() == 1)
        {
            calculo = calculo/=4;
        }
        else{
            if(getDiasPorCaducar() == 2)
            {
                calculo = calculo/=3;
            }
            else
                {
                    if (getDiasPorCaducar() == 3)
                        calculo = calculo/=2;
                }
        }
        return calculo;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "dias Por Caducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
