package ejercicio1_Banco.Interfaz;

/*https://docs.google.com/document/d/1tnBIpOQUsNgoPsOr3wJTOMiKK6fP8qTE/edit*/

public interface Transaccionable {
    default void transaccionOk(String tipoCliente){
        System.out.println("[Cliente " + tipoCliente + " se realizó correctamente");
    }

    default void transaccionNoOk(String tipoCliente){
        System.out.print("[Cliente " + tipoCliente + "] No se pudo realizar la operación ");
    }
}
