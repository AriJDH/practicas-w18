package com.meli.Bank.Operations;

public interface IDeposit extends ITransaction {
    public default void deposit(double val, int account) {
        System.out.println("Depositando: " + val + "$" + " a la cuenta: " + account);
    }
}
