package Transacciones;

public interface Transaccion {

    public void transaccionOK(){
        System.out.println("Transaccion OK");
    };
    public  void transaccionNoOK(){
        System.out.println("Transaccion fallida");
    };
}
