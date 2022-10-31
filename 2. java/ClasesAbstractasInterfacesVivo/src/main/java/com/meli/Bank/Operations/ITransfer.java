package com.meli.Bank.Operations;

public interface ITransfer extends ITransaction {
    public default void transfer(double val, int account) {
        System.out.println("Transfiriendo: " + val + "$" + " a la cuenta: " + account);
    }
}
