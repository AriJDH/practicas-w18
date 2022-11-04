package clases;

import repository.ClienteRepository;
import repository.LocalizadorRepository;

public class Agencia {
    private LocalizadorRepository localizadorRepository;
    private ClienteRepository clienteRepository;

    public Agencia(LocalizadorRepository localizadorRepository, ClienteRepository clienteRepository) {
        this.localizadorRepository = localizadorRepository;
        this.clienteRepository = clienteRepository;
    }
}
