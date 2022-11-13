package Exercise_2.ui;

import Exercise_2.model.*;
import java.util.Scanner;

public class UIMenu {

  public static void showMenu() {
    System.out.println("Welcome to the Archbold Files");
    System.out.println("Select an option");
    int response = 0;

    do {
      System.out.println("1. PDF");
      System.out.println("2. CV");
      System.out.println("3. Report");
      System.out.println("0. Exit");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          UIMenuFilePDF.showMenu();
          break;
        case 2:
          UIMenuFileCV.showMenu();
          break;
        case 3:
          break;
        case 0:
          System.out.println("Thank you for you visit");
          break;
        default:
          System.out.println("Please select a correct option");
          break;
      }
    } while (response != 0);
  }
}
