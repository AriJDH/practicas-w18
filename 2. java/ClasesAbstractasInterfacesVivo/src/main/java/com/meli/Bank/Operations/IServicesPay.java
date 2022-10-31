package com.meli.Bank.Operations;

public interface IServicesPay extends ITransaction {
    public default void pay(double val, String service) {
        System.out.println("Pagando: " + val + "$" + " al servicio: " + service);
    }
}
