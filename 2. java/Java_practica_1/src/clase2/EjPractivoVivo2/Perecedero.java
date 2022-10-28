package clase2.EjPractivoVivo2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = cantidadDeProductos * this.getPrecio();
        int descuento=1;

        switch (this.diasPorCaducar){
            case 1: descuento = 4;
                break;
            case 2: descuento = 3;
                break;
            case 3: descuento = 2;
                break;
        }
        precioFinal /= descuento;
        return precioFinal;
    }
}
