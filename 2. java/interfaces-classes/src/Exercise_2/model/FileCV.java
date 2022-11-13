package Exercise_2.model;

import Exercise_2.interfaces.Files;
import Exercise_2.ui.UIMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileCV extends File {

  @Override
  public void addFile() {
    System.out.println(":: Add a person ::");

    Scanner sc = new Scanner(System.in);
    HashMap<String, ArrayList<String>> dataPeople = new HashMap<>();

    System.out.println(":: Write a name to the person :: ");
    String name = sc.nextLine();

    System.out.println(":: Add Skills :: ");

    ArrayList<String> resumes = new ArrayList<>();

    int response = 0;
    do {
      System.out.println("1. Add new");
      System.out.println("0. Return");

      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          System.out.println(":: Write your skill :: ");
          resumes.add(sc.nextLine());
          break;
        default:
          System.out.println("Please select a correct option");
          break;
      }
    } while (response != 0);

    dataPeople.put(name, resumes);

    if (Files.arrayDataFiles.size() == 0) {
      Files.arrayDataFiles.put(1, dataPeople);
    } else {
      Files.arrayDataFiles.put(Files.arrayDataFiles.size() + 1, dataPeople);
    }

    UIMenu.showMenu();
  }
 
  @Override
  public void getFiles() {
    for (Map.Entry<Integer, Map<String, ArrayList<String>>> item : Files.arrayDataFiles.entrySet()) {
      System.out.println(":: Datatype :: ");
      System.out.println("/* CV */ ");
      for (Map.Entry<String, ArrayList<String>> item2 : item
        .getValue()
        .entrySet()) {
        System.out.println(":: Data :: ");
        System.out.println("> Name: " + item2.getKey() + " <");
        System.out.println("> Skills: " + item2.getValue() + " <");
      }
    }
  }
}
