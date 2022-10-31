import Clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inicializando banco");
        Ejecutivo ejecutivo = new Ejecutivo(8);
        ejecutivo.depositar(27.1, 19276196);
        ejecutivo.transferir(872.50, 2839326, 2938737);
    }
}