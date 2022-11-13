package Exercise_2.model;

import Exercise_2.interfaces.Files;
import Exercise_2.ui.UIMenu;
import java.util.Scanner;

public class Pdf extends File {
  private String attribute;
  private String quantityPages;
  private String nameAuthor;
  private String title;
  private String gender;

  @Override
  public void addFile() {
    System.out.println(":: Add a PDF ::");

    System.out.println(":: Write a name to the person :: ");
    Scanner sc = new Scanner(System.in);

    System.out.println("Attribute: ");
    attribute = sc.nextLine();
    System.out.println("Quantity pages: ");
    quantityPages = sc.nextLine();
    System.out.println("Name author:");
    nameAuthor = sc.nextLine();
    System.out.println("Title file:");
    title = sc.nextLine();
    System.out.println("Gender: ");
    gender = sc.nextLine();

    String dataFile =
      "Attribute: " +
      attribute +
      " Quantity pages: " +
      quantityPages +
      " Name author: " +
      nameAuthor +
      " Title file: " +
      title +
      " Gender:  " +
      gender;

    Files.arrayDataFilesPDF.add(dataFile);

    UIMenu.showMenu();
  }

  @Override
  public void getFiles() {
    for (String item : Files.arrayDataFilesPDF) {
      System.out.println(item);
    }
  }
}
