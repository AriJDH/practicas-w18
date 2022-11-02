package Logica;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadProductos){
        if(diasPorCaducar == 1){
            return super.calcular(cantidadProductos)/4;
        } else if(diasPorCaducar == 2) {
            return super.calcular(cantidadProductos)/3;
        } else if(diasPorCaducar == 3) {
            return super.calcular(cantidadProductos)/2;
        } else {
            return super.calcular(cantidadProductos);
        }
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
