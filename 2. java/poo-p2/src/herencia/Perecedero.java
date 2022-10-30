package herencia;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double res;
        double calculoParcial = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar) {
            case 1:
                res = calculoParcial / 4;
                break;
            case 2:
                res = calculoParcial / 3;
                break;
            case 3:
                res = calculoParcial / 2;
                break;
            default:
                res = calculoParcial;
                break;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + super.getNombre() + '\'' +
                ", precio=" + super.getPrecio() +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
