package Exercise_2.model;

import Exercise_2.interfaces.Files;
import Exercise_2.ui.UIMenu;
import java.util.Scanner;

public class Report extends File {
  private String text;
  private int quantityPages;
  private String author;
  private String reviewer;

  @Override
  public void addFile() {
    System.out.println(":: Add a PDF ::");

    System.out.println(":: Write a name to the person :: ");
    Scanner sc = new Scanner(System.in);

    System.out.println("Text: ");
    text = sc.nextLine();
    System.out.println("Quantity pages: ");
    quantityPages = Integer.valueOf(sc.nextLine());
    System.out.println("Name author:");
    author = sc.nextLine();
    System.out.println("Reviewer:");
    reviewer = sc.nextLine();

    String dataFile =
      "Text: " +
      text +
      " Quantity pages: " +
      quantityPages +
      " Name author: " +
      author +
      " Reviewer:  " +
      reviewer;

    Files.arrayDataFilesReports.add(dataFile);

    UIMenu.showMenu();
  }

  @Override
  public void getFiles() {
    for (String item : Files.arrayDataFilesReports) {
      System.out.println(item);
    }
  }
}
