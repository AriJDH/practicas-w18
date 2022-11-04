package org.example.services;

import org.example.domain.Cliente;
import org.example.repositories.ListRepository;
import org.example.repositories.RepositoryFactory;

public class ClienteRepositoryService extends RepositoryService<Cliente>{
    public ClienteRepositoryService() {
        super(RepositoryFactory.getClienteRepository());
    }
}
