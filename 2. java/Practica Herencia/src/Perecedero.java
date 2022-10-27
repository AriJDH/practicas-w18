public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadProductos) {
        double precio = super.calcular(cantidadProductos);
        double devolver = 0;
        if(this.diasPorCaducar == 1){
            devolver = precio + precio / 4;
        }else if(this.diasPorCaducar == 2){
            devolver = precio + precio / 3;
        }else if (this.diasPorCaducar == 3){
            devolver = precio + precio / 2;
        }

        return devolver;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
