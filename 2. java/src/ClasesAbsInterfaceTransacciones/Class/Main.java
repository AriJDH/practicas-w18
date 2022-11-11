package ClasesAbsInterfaceTransacciones.Class;

public class Main {
    public static void main (String[] args){
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();

        //Probando funciones
        ejecutivo.depositarMonto(true);
        ejecutivo.realizarTransferencia(true);

    }
}
