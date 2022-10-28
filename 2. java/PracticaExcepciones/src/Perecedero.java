public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
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

    @Override
    public double calcular(int cantidadDeProductos){

        int reduccion = 1;

        switch (this.diasPorCaducar){
            case 1:
                reduccion = 4;
                break;
            case 2:
                reduccion = 3;
                break;
            case 3:
                reduccion = 2;
                break;
        }
        return this.precio*cantidadDeProductos/reduccion;

    }
}
