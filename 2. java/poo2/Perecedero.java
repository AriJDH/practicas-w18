public class Perecedero extends  Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = (getPrecio()*cantidadDeProductos);
        if(this.diasPorCaducar == 1){
            resultado = resultado * 0.25;
        }else if(this.diasPorCaducar == 2){
            resultado = resultado * 0.33;
        }else  if(this.diasPorCaducar == 3){
            resultado = resultado * 0.5;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
