package com.meli.model;

import java.util.List;

public class Locator {

    private String id;
    private Client client;
    private List<Package> packageList;

    public Locator(String id, Client client, List<Package> packageList) {
        this.id = id;
        this.client = client;
        this.packageList = packageList;
    }

    public double getTotal() {
        double total = packageList.stream().mapToDouble(p -> p.getProductList().stream().mapToDouble(product -> product.getPrice()).sum()).sum();
        System.out.println("Total neto: " + total);
        if (buyDuoHotelAndTickets()) {
            total = total - (total * 0.05d);
            System.out.println("Se aplica descuento del 5% por compra de doble hotel y doble boletos");
        }
        if (client.isLoyalCustomer()) {
            System.out.println("Se aplica descuento del 5% por cliente fiel");
            total = total - (total * 0.05d);
        }
        if (buyCompletePackage()) {
            System.out.println("Se aplica descuento del 10% por comprar paquete completo");
            total = total - (total * 0.1d);
        }
        return total;
    }

    private boolean buyCompletePackage() {
        return this.packageList.stream().map(pack -> pack.isCompletePackage()).findFirst().orElse(false);
    }

    private boolean buyDuoHotelAndTickets() {
        boolean duoHotel = this.packageList.stream().map(pack -> pack.getProductList().stream().filter(product -> product.getName().equals("hotel")).count() >= 2).findFirst().orElse(false);
        boolean duoTickets = this.packageList.stream().map(pack -> pack.getProductList().stream().filter(product -> product.getName().equals("boletos")).count() >= 2).findFirst().orElse(false);
        return duoHotel == true && duoTickets == true;
    }

    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    @Override
    public String toString() {
        return "Locator{" + "\n" + "  id: " + id + "\n" + "  client: " + client + "\n" + "  packageList: " + packageList + "\n" + '}';
    }
}
