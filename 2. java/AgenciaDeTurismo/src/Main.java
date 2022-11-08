public class Main {

    public class Main {
        public static void main(String[] args) {
            System.out.println("Escenario 1");
            RepositorioBase repo = new BoletoViaje(new Hotel(new Comida(new BoletoTransporte(new Repositorio()))));
            Cliente c1 = new Cliente(repo,"Roberto",1001031313);
            System.out.println(c1);

            System.out.println("\nEscenario 2");
            RepositorioBase repo2 = new BoletoViaje(new BoletoViaje(new Hotel(new Hotel(new Repositorio()))));
            c1.setRepositorio(repo2);
            System.out.println(c1);

            System.out.println("\nEscenario 3");
            RepositorioBase repo3 = new Hotel(new Repositorio());
            c1.setRepositorio(repo3);
            System.out.println(c1);


        }
    }
