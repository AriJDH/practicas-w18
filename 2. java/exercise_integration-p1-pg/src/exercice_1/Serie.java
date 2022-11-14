package exercice_1;

public class Serie extends PrototypeClass {

  public void showDataSerie() {
    System.out.println("-------------------");
    for (Integer integer : getSerie()) {
      System.out.println(integer);
    }
    System.out.println("-------------------");
  }

  public void serieProcess(int first) {
    for (int i = 0; i < first; i++) {
      setSerieValue(nextValue(first));
    }
  }
}
