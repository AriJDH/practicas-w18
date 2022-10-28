import ejercicio1_Banco.ClasesClientes.Basic;
import ejercicio1_Banco.ClasesClientes.Cobrador;
import ejercicio1_Banco.ClasesClientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        System.out.println(" --------------- TRANSACCIONES Y CLIENTE ---------------");


        Basic b1 = new Basic(5000);
        b1.consultar();
        b1.pagar(5000);
        b1.retirar(2000);

        Cobrador c1 = new Cobrador(5000);
        c1.consultar();
        c1.retirar(6000);

        Ejecutivo e1 = new Ejecutivo(5000);
        e1.consultar();
        e1.transferir(2000);
        e1.depositar(4000);




    }
}