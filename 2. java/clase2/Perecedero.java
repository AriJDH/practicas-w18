package clase2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //override to string
    public String toString() {
        return "Perecedero{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    //override calcular
    public void calcular(int cantidad) {
        if (diasPorCaducar <= 1)
            setPrecio((getPrecio() * cantidad )/ 4);
        else if (diasPorCaducar <= 2)
            setPrecio((getPrecio() * cantidad )/ 3);
        else if (diasPorCaducar <= 3)
            setPrecio((getPrecio() * cantidad )/ 2);
        else
            setPrecio(getPrecio() * cantidad);
    }
}

