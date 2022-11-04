package com.meli.Controllers;

import com.meli.Db.Database;
import com.meli.Services.ILocatorRepository;
import com.meli.model.Client;
import com.meli.model.Locator;
import com.meli.model.Package;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class LocatorController {

    ILocatorRepository iLocatorRepository;

    public LocatorController(Database databaseConnection) {
        this.iLocatorRepository = databaseConnection;
    }

    public Locator post(List<Package> packageList, Client client) {
        var locator = new Locator(
                UUID.randomUUID().toString() + new Date().toString().replaceAll("\\s",""),
                    client,
                    packageList
        );
        ;
        return iLocatorRepository.createLocator(locator) ? locator : null;
    }

    public Locator get(String id){
        return iLocatorRepository.selectLocator(id);
    }

    public double getTotalLocator(String id){
        return iLocatorRepository.getTotalLocator(id);
    }

    public void put(Locator locator) {
        iLocatorRepository.updateLocator(locator);
    }
}
