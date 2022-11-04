package com.meli.Controllers;

import com.meli.Db.Database;
import com.meli.Services.IClientRepository;
import com.meli.model.Client;

public class ClientController {

    IClientRepository iClientRepository;

    public ClientController(Database databaseConnection) {
        this.iClientRepository = databaseConnection;
    }

    public void post(Client client) {
        iClientRepository.createClient(client);
    }

    public Client get(String id) {
        return iClientRepository.selectClient(id);
    }

    public void put(Client client) {
        iClientRepository.updateClient(client);
    }

}
