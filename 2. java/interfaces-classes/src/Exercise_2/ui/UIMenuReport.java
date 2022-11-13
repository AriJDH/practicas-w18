package Exercise_2.ui;

import Exercise_2.model.*;
import java.util.Scanner;

public class UIMenuReport {

  public static void showMenu() {
    Report report = new Report();

    System.out.println(":: Menu CV ::");
    System.out.println("Select an option");
    int response = 0;

    do {
      System.out.println("1. Add CV");
      System.out.println("2. Get files");
      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          report.addFile();
          break;
        case 2:
          report.getFiles();
          break;
        case 0:
          UIMenu.showMenu();
          break;
        default:
          System.out.println("Please select a correct option");
          break;
      }
    } while (response != 0);
  }
}
