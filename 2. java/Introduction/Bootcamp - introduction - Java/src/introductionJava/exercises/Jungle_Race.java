package introductionJava.exercises;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Jungle_Race {

  public static void main(String[] args) {
    ArrayList<String> categories = initArrayCategories();
    Map<Integer, String> users = new HashMap<>();
   
  }

  public static ArrayList<String> initArrayCategories() {
    ArrayList<String> listOfCategories = new ArrayList<String>() {};
    listOfCategories.add("circuito_chico");
    listOfCategories.add("circuito_medio");
    listOfCategories.add("circuito_avanzado");
    return listOfCategories;
  }
}
