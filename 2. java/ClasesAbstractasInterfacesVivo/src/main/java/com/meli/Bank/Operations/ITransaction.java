package com.meli.Bank.Operations;

public interface ITransaction {
    default void transactionOk() {
        System.out.println("Transacción exitosa.");
    }

    default void transactionNoOk() {
        System.out.println("Transacción no exitosa.");
    }
}
