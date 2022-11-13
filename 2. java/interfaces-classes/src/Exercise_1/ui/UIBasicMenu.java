package Exercise_1.ui;

import Exercise_1.model.Basic;
import java.util.Scanner;

public class UIBasicMenu {

  public static void showBasicMenu() {
    Basic basic = new Basic();

    int response = 0;
    String userResponse;

    do {
      System.out.println(":: Basic user ::");
      System.out.println("1. Pay service");
      System.out.println("2. Consult your current balance");
      System.out.println("3. Get money");
      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          int amount;
          System.out.println(":: Pay service :: ");
          System.out.println(":: What type of service do you want to pay? :: ");
          userResponse = sc.nextLine();
          System.out.println("How much do you want to pay ?");
          amount = Integer.valueOf(sc.nextLine());
          basic.payService(userResponse, amount);
          break;
        case 2:
          System.out.println(":: Current balance :: ");
          basic.consultBalance();
          break;
        case 3:
          System.out.println(":: Get money :: ");
          System.out.println(":: How much money do you want to get? :: ");
          amount = Integer.valueOf(sc.nextLine());
          basic.doCashWithDrawal(amount);
          break;
        case 0:
          UIMenu.showMenu();
          break;
      }
    } while (response != 0);
  }
}
