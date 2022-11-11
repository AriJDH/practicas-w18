package clase4_b_EjerciciosIntegrador;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();

        Cliente cliente1 = new Cliente("3321234", "Sebastian Gines");

        Paquete paq = new Paquete();
        List<Reserva> paquete = (List<Reserva>) paq;


        Localizador localizador1 = new Localizador(repositorioLocalizador.traerTodos().size(), cliente1, paquete);

    }
}
