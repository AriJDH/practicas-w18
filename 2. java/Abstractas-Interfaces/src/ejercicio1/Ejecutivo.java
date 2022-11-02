package ejercicio1;

public class Ejecutivo extends Cliente{

    public Ejecutivo(String nombre, int cantidad){
        super(nombre,2);
        transacciones[0]= new Deposito();
        transacciones[1]= new Transferencia();
    }
}
