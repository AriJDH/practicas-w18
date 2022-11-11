public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo){
        super(nombre, precio);
        this.tipo = tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return super.toString() + "Clasificación de producto: No Perecedero" + "\n" +
                "Tipo de producto: " + this.tipo;
    }

    @Override
    public int calcular(int cantidadDeProductos){
        return super.calcular(cantidadDeProductos);
    }


}
