
public class Perecedero extends Producto{

    protected int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //Getters and Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Es Perecedero y le faltan" +
                diasPorCaducar + " días por caducar\n";
    }

    //Metodos Propios:

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = precio * cantidadDeProductos;
        switch (diasPorCaducar){
            case 1: precioFinal = 0.25 * precioFinal;
                    break;
            case 2: precioFinal = precioFinal/3;
                    break;
            case 3: precioFinal = 0.5 * precioFinal;
                    break;
        }
        return precioFinal;
    }
}
