package ejerciciointegradores91vivo;

import java.util.List;

public interface IRepositorioLocalizador {
	
	void almacenarLocalizador(Localizador localizadores);
	
	void imprimirLocalizadorGenerado(Localizador localizador);
	
	int descuentoPorCliente(Cliente cliente);
	
	void agregarCliente(Cliente cliente);

}
