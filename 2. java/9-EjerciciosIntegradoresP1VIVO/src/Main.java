import model.*;
import repository.ClienteRepository;
import repository.LocalizadorRepository;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
	// Reservas
		BoletoViaje boletoViaje = new BoletoViaje();
		boletoViaje.setPrecioUnitario(100.00);
		boletoViaje.calcularPrecio(1);
		Comida comida = new Comida();
		comida.setPrecioUnitario(200.00);
		comida.calcularPrecio(2);
		Hotel hotel = new Hotel();
		hotel.setPrecioUnitario(300.00);
		hotel.calcularPrecio(2);
		Transporte transporte = new Transporte();
		transporte.setPrecioUnitario(400.00);
		transporte.calcularPrecio(1);
		
		Paquete paquete = new Paquete(Arrays.asList(boletoViaje, hotel, transporte, comida));
		paquete.calcularPrecio(1);
		
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		Localizador localizador = new Localizador(1L, 1L);
		localizador.agregarReservable(paquete, 2);
		
		cliente.agregarLocalizador(localizador);
		
		ClienteRepository clienteRepository = new ClienteRepository();
		clienteRepository.agregar(cliente);
		
		LocalizadorRepository localizadorRepository = new LocalizadorRepository();
		localizadorRepository.agregar(localizador);
		System.out.println(clienteRepository.buscarPorId(1L));
		System.out.println(localizadorRepository.buscarPorId(1L));
	}
}