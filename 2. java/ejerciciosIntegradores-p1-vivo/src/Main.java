import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Paquete paquete1 = new Paquete(
                "Aaa",
                "Pescado",
                null,
                null,
                2.00);
        Paquete paquete2 = new Paquete(
                "Ccc",
                "Pescado",
                "Bbbb",
                "Tren",
                4.06);
        List<Paquete> reservas1 = new ArrayList<>();
        reservas1.add(paquete1);
        reservas1.add(paquete2);
        Repositorio<Cliente> clienteRepositorio = new RepositorioCliente();
        clienteRepositorio.agregar(new Cliente(1));
        clienteRepositorio.agregar(new Cliente(2));
        clienteRepositorio.agregar(new Cliente(3));
        Localizador localizador = new Localizador(reservas1, new Cliente(1));
        localizador.calcularTotal();
        System.out.println(localizador);
    }
}