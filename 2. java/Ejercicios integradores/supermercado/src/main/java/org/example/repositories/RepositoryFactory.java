package org.example.repositories;

import org.example.domain.Cliente;
import org.example.domain.Factura;

public class RepositoryFactory {
    private static ListRepository<Cliente> clienteRepository = null;
    private static ListRepository<Factura> facturaRepository = null;

    public static ListRepository<Cliente> getClienteRepository(){
        if(clienteRepository!=null)
            return clienteRepository;
        else{
            clienteRepository=new ListRepository<>();
            return clienteRepository;
        }
    }

    public static ListRepository<Factura> getFacturaRepository(){
        if(facturaRepository!=null)
            return facturaRepository;
        else{
            facturaRepository=new ListRepository<>();
            return facturaRepository;
        }
    }
}
