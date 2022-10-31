package com.meli.Bank.Operations;

public interface ICashWithdrawal extends ITransaction {
    public default void withdrawal(double val) {
        System.out.println("Retirando: " + val);
    }
}
