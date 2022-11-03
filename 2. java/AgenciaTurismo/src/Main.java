import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Pepe",23412345);
        PaqueteTuristico paquete = new PaqueteTuristico(false,false,false,false,true);
        PaqueteTuristico paquete2 = new PaqueteTuristico(true,false,true,false,false);
        List<PaqueteTuristico> paquetes = new ArrayList<PaqueteTuristico>();
        paquetes.add(paquete);
        paquetes.add(paquete2);
        Repositorio repo = new Repositorio(cliente,paquetes);
        repo.calcularPrecio(paquete);
        repo.calcularPrecio(paquete2);
        repo.mostrarReserva(paquete,cliente);
    }
}