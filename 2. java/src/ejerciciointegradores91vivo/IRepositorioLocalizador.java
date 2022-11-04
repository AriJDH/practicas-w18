package ejerciciointegradores91vivo;

import java.util.List;

public interface IRepositorioLocalizador {
	
	void almacenarLocalizador(Localizador localizadores);
	
	void imprimirLocalizadorGenerado(Localizador localizador);
	
	int localizadoresPorCliente(Cliente cliente);
	
	void agregarCliente(Cliente cliente);

}
