import clases.Supermercado;

public class Main {
    public static void main(String[] args) {
        Supermercado meli = new Supermercado();

        meli.crearCliente("40665994", "Jonathan", "Caucota");
        meli.crearCliente("23123213", "Leonardo", "Alvarez");
        meli.crearCliente("12315233", "Ezequiel", "Riestra");

        meli.mostrarDatosClientes();

        System.out.println("-------Eliminando Cliente-------");
        meli.eliminarCliente("40665994");
        System.out.println("---------");
        meli.mostrarDatosClientes();
        System.out.println("-------Buscar Cliente-------");
        meli.buscarCliente("12315233");
        meli.buscarCliente("123");


    }
}