package ejercicio1;

public class Basic extends Cliente{

    public Basic(String nombre, int cantidad) {
        super(nombre, 3);
        transacciones[0]= new ConsultaDeSaldo();
        transacciones[1]= new PagoDeServicio();
        transacciones[2]= new RetiroDeEfectivo();
    }
}
