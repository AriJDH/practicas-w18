package Exercise_1.ui;

import java.util.Scanner;

public class UIMenu {

  public static void showMenu() {
    System.out.println("Welcome to the Bank");
    System.out.println("Select a type of user");

    int response = 0;
    do {
      System.out.println("1. Basic");
      System.out.println("2. Collector");
      System.out.println("3. Executive");
      System.out.println("0. Exit");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          UIBasicMenu.showBasicMenu();
          break;
        case 2:
          UICollectorMenu.showCollectorMenu();
          break;
        case 3:
          UIExecuteMenu.showExecutiveMenu();
          break;
        case 0:
          System.out.println("Thank you for you visit");
          break;
        default:
          System.out.println("Please select a correct answer");
          break;
      }
    } while (response != 0);
  }
}
