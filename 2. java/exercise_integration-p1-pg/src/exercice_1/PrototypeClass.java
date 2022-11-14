package exercice_1;

import java.util.ArrayList;
import java.util.List;

/**
 * PrototypeClass
 */
public abstract class PrototypeClass {
  public List<Integer> serie = new ArrayList<Integer>();

  public Integer nextValue(Integer value) {
    int sum = serie.get(serie.size() - 1) + value;
    return sum;
  }

  public void resetSerie() {
    serie.clear();
    System.out.println("Array reset.");
  }

  public void startSerie(Integer value) {
    serie.add(value);
  }

  public void setSerieValue(Integer value) {
    serie.add(value);
  }

  public List<Integer> getSerie() {
    return serie;
  }

  public Integer getSerieValue(int index) {
    return serie.get(index);
  }
}
