package ejercicio1;

public class Cobrador extends Cliente{

    public Cobrador(String nombre, int cantidad) {
        super(nombre, 2);
        transacciones[0]= new RetiroDeEfectivo();
        transacciones[1]= new ConsultaDeSaldo();
    }
}
