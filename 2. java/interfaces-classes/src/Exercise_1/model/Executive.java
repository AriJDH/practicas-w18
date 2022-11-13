package Exercise_1.model;

import Exercise_1.interfaces.Deposit;
import Exercise_1.interfaces.Transfer;
import Exercise_1.interfaces.Transactions;

public class Executive implements Deposit, Transfer {

  @Override
  public void doDeposit() {
    System.out.println("Doing a deposit.");

    if (Transactions.getRandomNumber() == 1) {
      transactionOK("Pay Service");
    } else {
      transactionNoOK("Pay Service");
    }
  }

  @Override
  public void doTransfer() {
    System.out.println("Doing a transfer");

    if (Transactions.getRandomNumber() == 1) {
      transactionOK("Pay Service");
    } else {
      transactionNoOK("Pay Service");
    }
  }

  @Override
  public void transactionOK(String transactionType) {
    System.out.println(transactionType + " Trasanction was successful. ");
  }

  @Override
  public void transactionNoOK(String transactionType) {
    System.out.println(transactionType + " Trasanction was unsuccessful ");
  }
}
