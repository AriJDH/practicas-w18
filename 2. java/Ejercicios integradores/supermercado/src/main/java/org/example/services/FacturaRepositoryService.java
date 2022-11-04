package org.example.services;

import org.example.domain.Cliente;
import org.example.domain.Factura;
import org.example.repositories.ListRepository;
import org.example.repositories.RepositoryFactory;

public class FacturaRepositoryService extends RepositoryService<Factura>{
    private ClienteRepositoryService clienteRepositoryService= new ClienteRepositoryService();
    public FacturaRepositoryService() {
        super(RepositoryFactory.getFacturaRepository());
    }
    @Override
    public void add(Factura factura){
        Cliente cliente = factura.getCliente();
        if(cliente!=null){
            if(!clienteRepositoryService.find(cliente).isPresent()){
                clienteRepositoryService.add(cliente);
            }
        }
        super.add(factura);
    }
}
