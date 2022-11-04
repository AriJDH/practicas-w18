package com.meli.model;

public class Client {
    private String id;
    private String name;
    private boolean loyalCustomer = false;

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isLoyalCustomer() {
        return loyalCustomer;
    }

    public void setLoyalCustomer(boolean loyalCustomer) {
        this.loyalCustomer = loyalCustomer;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
