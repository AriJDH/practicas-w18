package SupermercadoEconomico;

import SupermercadoEconomico.modelo.Cliente;
import SupermercadoEconomico.modelo.Item;
import SupermercadoEconomico.repository.ClienteImp;
import SupermercadoEconomico.repository.FacturaImp;
import SupermercadoEconomico.repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClienteImp cliImp = new ClienteImp();
        FacturaImp factImp = new FacturaImp();
        ItemImp itemImp = new ItemImp();


        //Creamos 3 clientes
        Cliente cliente1 = new Cliente("123123123", "Raul", "Tevez");
        Cliente cliente2 = new Cliente("345345345", "Mario", "Artaza");
        Cliente cliente3 = new Cliente("567567567", "Carlos", "Zocasa");

        //guardamos los clientes
        cliImp.save(cliente1);
        cliImp.save(cliente2);
        cliImp.save(cliente3);

        //Mostramos los clientes por pantalla
        cliImp.mostrarPantalla();

        //Buscamos un cliente mediante su dni
        System.out.println("Ingresa el DNI del cliente a buscar: ");
        String dniBuscar = teclado.next();
        cliImp.buscar(dniBuscar);

        System.out.println("Ingrese el DNI de la persona a borrar: ");
        String dniBorrar = teclado.next();

        cliImp.eliminar(dniBorrar);

    }
}
