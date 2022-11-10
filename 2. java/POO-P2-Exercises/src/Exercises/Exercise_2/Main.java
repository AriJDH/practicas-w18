package Exercises.Exercise_2;

public class Main {

  public static void main(String[] args) {
    Perecedero perecedero = new Perecedero("CARNE", 1000, 1);

    NoPerecedero noPerecedero = new NoPerecedero(
      "Portatil ASUS",
      1500,
      "Portatil"
    );
    Perecedero perecedero2 = new Perecedero("PAN", 500, 3);
    NoPerecedero noPerecedero2 = new NoPerecedero(
      "Portatil APPLE",
      5000,
      "Portatil"
    );
    Perecedero perecedero3 = new Perecedero("ATUN", 300, 15);

    // System.out.println(perecedero.calcular(3));

    Producto[] productos = {
      perecedero,
      noPerecedero,
      perecedero2,
      noPerecedero2,
      perecedero3,
    };

    Distribuidora distribuidora = new Distribuidora(productos);

    distribuidora.printResults();
  }
}
