package Exercise_2.interfaces;

import Exercise_2.ui.UIMenu;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public interface Files {
  public static Map<Integer, Map<String, ArrayList<String>>> arrayDataFiles = new TreeMap<>();
  public static ArrayList<String> arrayDataFilesPDF = new ArrayList<>();
  public static ArrayList<String> arrayDataFilesReports = new ArrayList<>();

  public static void print() {
    UIMenu.showMenu();
  }
}
