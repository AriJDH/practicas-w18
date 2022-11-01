
public class Perecedero extends Producto {

    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
        return "Perecedero{" +
                "nombre='" + super.getNombre() + '\'' +
                ", precio=" + super.getPrecio() +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos) {
        double previo = super.calcular(cantidadProductos);
        if (diasPorCaducar == 1){
            return previo/4;
        }
        if (diasPorCaducar == 2){
            return previo/3;
        }
        if (diasPorCaducar == 3){
            return previo/4;
        }
        if (diasPorCaducar > 3){
            return previo;
        }else{
            return  -1;
        }
    }


}