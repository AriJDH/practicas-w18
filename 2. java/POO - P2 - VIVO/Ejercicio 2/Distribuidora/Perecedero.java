public class Perecedero extends Producto{

    private int diasPorCaducar;

    //Constructor que recibe su atributo como parametro
    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //Metodo Setter
    public void setDiasPorCaducar(int diasPorCaducar){
        this.diasPorCaducar = diasPorCaducar;
    }

    //Metodo Getter
    public int getDiasPorCaducar(){
        return this.diasPorCaducar;
    }

    //Sobreescritura del metodo toString()
    public String toString(){

        return super.toString() + "Clasificación de producto: Perecedero" + "\n" +
                "Caduca en: " + this.diasPorCaducar + " Días.";
    }

    //Sobreescritura del metodo calcular()
    @Override
    public int calcular(int cantidadDeProductos){
        int precioFinal;

        if(this.diasPorCaducar == 1){
            precioFinal = super.calcular(cantidadDeProductos) / 4;
        } else if(this.diasPorCaducar == 2) {
            precioFinal = super.calcular(cantidadDeProductos) / 3;
        } else {
            precioFinal = super.calcular(cantidadDeProductos) / 2;
        }

        return precioFinal;
    }


}
