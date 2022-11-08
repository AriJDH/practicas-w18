import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(37518629, "Macarena", "Spalenza");
        Cliente cliente2 = new Cliente(20378932, "Pedro", "Montserrat");
        Cliente cliente3 = new Cliente(30281923, "Mabel", "Pescara");

        List<Cliente> clientes = Arrays.asList(cliente1,cliente2, cliente3);

    }
}
