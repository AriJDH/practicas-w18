package exercice_2;

import exercice_2.model.Client;
import exercice_2.repository.ClientImplementation;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    ClientImplementation clientImplementation = new ClientImplementation();

    Client c1 = new Client(1928384123L, "Angel", "Archbold");
    Client c2 = new Client(121228384123L, "Junior", "Torres");
    Client c3 = new Client(1923123384123L, "Milena", "Sandoval");

    clientImplementation.save(c1);
    clientImplementation.save(c2);
    clientImplementation.save(c3);

    clientImplementation.show();

    Scanner sc = new Scanner(System.in);

    System.out.println(":: Insert Dni to find a client :: ");
    Long DNIToFind = sc.nextLong();
    clientImplementation.find(DNIToFind);

    System.out.println(":: Insert Dni to delete a client :: ");
    Long DNIToDelete = sc.nextLong();
    clientImplementation.delete(DNIToDelete);
  }
}
