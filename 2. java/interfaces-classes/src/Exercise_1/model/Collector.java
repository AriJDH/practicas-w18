package Exercise_1.model;

import Exercise_1.interfaces.CashWithDrawal;
import Exercise_1.interfaces.ConsultBalance;

public class Collector implements CashWithDrawal, ConsultBalance {

  @Override
  public void consultBalance() {
    System.out.println("Your current balance is: " + Math.random());
  }

  @Override
  public void doCashWithDrawal(double amount) {
    System.out.println("You will get: " + amount);
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
