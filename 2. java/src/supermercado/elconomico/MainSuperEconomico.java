package supermercado.elconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainSuperEconomico {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente(50439865, "Jose", "Sandona");
		Cliente cliente2 = new Cliente(87654321, "Juan", "Zarate");
		Cliente cliente3 = new Cliente(12345678, "Manuel", "Delgado");
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		clientes.stream().forEach(c -> {
			System.out.println(c.toString());
		});
		
		System.out.println("***** Eliminamos cliente 12345678 y pintamos nuevamente la lista ********");
		
		clientes.remove(cliente3);		
		clientes.stream().forEach(c -> {
			System.out.println(c.toString());
		});
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("***** Ingrese una cedula para buscar en la lista de cliente: ********");
		int cedula = teclado.nextInt();
		
		
		Optional<Cliente> clienteEncontrado = clientes.stream().filter(c-> c.getDni() == cedula).findFirst();
		if(clienteEncontrado.isPresent())
			System.out.println("Datos del cliente buscado: " + clienteEncontrado.toString());
		else
			System.out.println("No se encontro cliente con la cedula " + cedula);
		
	}
}
