package com.meli.Services;

import com.meli.model.Client;

import java.util.List;

public interface IClientRepository<C extends Client> {

    boolean createClient(C client);

    C selectClient(String id);

    boolean updateClient(C client);

    boolean deleteClient(C client);

    List<C> getAllClients();
}
