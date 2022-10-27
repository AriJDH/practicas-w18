package introductionJava.exercises;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Calculate_Bills {
  // Este tipo de dato sera visto en la siguiente clase en vivo
  List<String> messageStrings = new LinkedList<>();

  public static void main(String[] args) {
    int[] serviciosCli = { 1, 1, 2, 2, 2, 1, 2 };
    String[] nameService = {
      "Seguridad con cámaras",
      "Seguridad con cámaras + patrullaje",
    };

    double totalBill;
    
    for (int i = 0; i < serviciosCli.length; i++) {
      System.out.println(serviciosCli[i]);
      if (serviciosCli[i] == 1) {
        totalBill = 1500;
        System.out.println("El tipo de servicio es: " + serviciosCli[i]);
        System.out.println("El monto de la factura es de: " + totalBill);
      } else {
        totalBill = 2200;
        System.out.println("El tipo de servicio es: " + serviciosCli[i]);
        System.out.println("El monto de la factura es de: " + totalBill);
        System.out.println(totalBill);
      }
    }
  }
}
