package Exercise_1.ui;

import Exercise_1.model.Collector;
import java.util.Scanner;

public class UICollectorMenu {
    public static void showCollectorMenu() {
    Collector collector = new Collector();

    int response = 0;

    do {
      System.out.println(":: Collector user ::");
      System.out.println("1. Consult your current balance");
      System.out.println("2. Get money");
      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          System.out.println(":: Current balance :: ");
          collector.consultBalance();
          break;
        case 2:
          System.out.println(":: Get money :: ");
          System.out.println(":: How much money do you want to get? :: ");
          int amount = Integer.valueOf(sc.nextLine());
          collector.doCashWithDrawal(amount);
          break;
        case 0:
          UIMenu.showMenu();
          break;
      }
    } while (response != 0);
  }
}
