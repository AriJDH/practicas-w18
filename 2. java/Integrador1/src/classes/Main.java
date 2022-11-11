package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente1 = new Cliente("Carlos", "Rodriguez", "44112244");
        Cliente cliente2 = new Cliente("Pedro", "Perez", "33667744");
        Cliente cliente3 = new Cliente("Ricardo", "Alvarez", "43768989");

        List<Cliente> list = new ArrayList();

        /*
        list.add(cliente1);
        list.add(cliente2);
        list.add(cliente3);
        */

        Collections.addAll(list, cliente1, cliente2, cliente3);


        list.stream()
                .forEach(System.out::println);


        list.remove(2);

        list.stream()
                .forEach(System.out::println);

        String dni = sc.nextLine();
        list.stream()
                .filter()



    }



}
