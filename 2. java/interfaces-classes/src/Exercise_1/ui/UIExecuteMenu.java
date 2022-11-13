package Exercise_1.ui;

import Exercise_1.model.Executive;

import java.util.Scanner;

public class UIExecuteMenu {

  public static void showExecutiveMenu() {
    Executive executive = new Executive();

    int response = 0;

    do {
      System.out.println(":: Executive user ::");
      System.out.println("1. Do a deposit");
      System.out.println("2. Do a transfer");
      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          System.out.println(":: Doing a deposit :: ");
          executive.doDeposit();
          break;
        case 2:
          System.out.println(":: Doing a transfer :: ");
          executive.doTransfer();
          break;
        case 0:
          UIMenu.showMenu();
          break;
      }
    } while (response != 0);
  }
}
