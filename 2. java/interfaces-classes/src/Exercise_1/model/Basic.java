package Exercise_1.model;

import Exercise_1.interfaces.CashWithDrawal;
import Exercise_1.interfaces.ConsultBalance;
import Exercise_1.interfaces.PayService;
import Exercise_1.interfaces.Transactions;

public class Basic implements ConsultBalance, PayService, CashWithDrawal {

  @Override
  public void payService(String typeService, int amount) {
    System.out.println(
      "You are paying this service: " + typeService + " amount: " + amount
    );

    if (Transactions.getRandomNumber() == 1) {
      transactionOK("Pay Service");
    } else {
      transactionNoOK("Pay Service");
    }
  }

  @Override
  public void consultBalance() {
    System.out.println("Your current balance is: " + (int) (Math.random() * 10000));
    if (Transactions.getRandomNumber() == 1) {
      transactionOK("Pay Service");
    }else{
      transactionNoOK("Pay Service");
    }
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
