package com.meli.Bank.Operations;

public interface IBalanceInquiry extends ITransaction {
    public default void query() {
        System.out.println("Saldo: " + 120000 + "$");
    }
}
