package exercice_1;
public class Main {

  public static void main(String[] args) {
    Serie serie = new Serie();

    int first = 3;
    serie.startSerie(first);
    serie.serieProcess(first);
    serie.showDataSerie();
    serie.resetSerie();
    first = 6;
    serie.startSerie(first);
    serie.serieProcess(first);
    serie.showDataSerie();
    serie.resetSerie();
    first = 12;
    serie.startSerie(first);
    serie.serieProcess(first);
    serie.showDataSerie();
  }
}
