package Exercise_2.ui;

import Exercise_2.model.*;
import java.util.Scanner;

public class UIMenuFilePDF {

  public static void showMenu() {
    Pdf pdf = new Pdf();
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
          pdf.addFile();
          break;
        case 2:
          pdf.getFiles();
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
