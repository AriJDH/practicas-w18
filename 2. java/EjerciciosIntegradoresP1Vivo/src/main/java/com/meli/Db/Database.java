package com.meli.Db;

import com.meli.Services.IClientRepository;
import com.meli.Services.ILocatorRepository;
import com.meli.model.Client;
import com.meli.model.Locator;

import java.util.ArrayList;
import java.util.List;

public class Database implements IClientRepository<Client>, ILocatorRepository<Locator> {

    private List<Locator> locatorList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();

    @Override
    public boolean createClient(Client client) {
        if (this.selectClient(client.getId()) != null) {
            System.out.println("Este cliente ya existe en la base de datos: " + "\n"+ client);
            return false;
        } else {
            this.clientList.add(client);
            System.out.println("Este cliente fue agregado con exito a la base de datos:" + "\n" + client);
            return true;
        }
    }

    @Override
    public Client selectClient(String id) {
        return this.clientList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean updateClient(Client client) {
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        return false;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public boolean createLocator(Locator locator) {
        if (this.selectLocator(locator.getId()) != null) {
            System.out.println("Este localizador ya existe en la base de datos: " + locator);
            return false;
        } else {
            this.locatorList.add(locator);
            System.out.println("Este localizador fue agregado con exito a la base de datos:" + locator);

            if(!locator.getClient().isLoyalCustomer()){

                var amountPurchases  = locatorList.stream().filter( l -> l.getClient().getId().equals(locator.getClient().getId())).count();
                System.out.println(amountPurchases);

                if (amountPurchases>2){
                    System.out.println("felicidaes "+ locator.getClient().getName()+" se determina que eres un cliente fiel!");
                    locator.getClient().setLoyalCustomer(true);
                }
            }
            return true;
        }
    }

    private boolean loyalCustomer(Client client){
        if( client.isLoyalCustomer()){
            return true;
        }else{
            var amountLocators = this.locatorList.stream().
                    filter( l -> l.getClient().getId().equals(client.getId())).count();
            if(amountLocators>=3){
                return true;
            }
            return false;
        }
    }

    @Override
    public List<Locator> getAllLocators() {
        return locatorList;
    }

    public double getTotalLocator(String id){
        var local = this.locatorList.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
        if(local!=null){
            return local.getTotal();
        }else{
            return Double.NaN;
        }
    }

    @Override
    public Locator selectLocator(String id) {
        return this.locatorList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean updateLocator(Locator locator) {
        return false;
    }

    @Override
    public boolean deleteLocator(Locator locator) {
        return false;
    }
}
