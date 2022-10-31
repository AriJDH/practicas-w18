package poo.exercises.pooLive1;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

    System.out.println();
    Person personNoData = new Person();
    Person personBasicData = new Person("Angel", 23, null); // ¿Qué sucede si tratamos de hacer esto? Se colocan valores nulos por defecto o tira un error

    System.out.print("Whats your name?: ");
    String name = sc.next();
    System.out.print("How many years do you have?: ");
    int age = sc.nextInt();
    System.out.print("Whats is your DNI?: ");
    String dni = sc.next();
    System.out.print("Whats is your weight?: ");
    int weight = sc.nextInt();
    System.out.print("Whats is your height?: ");
    double height = sc.nextDouble();

    Person personFullData = new Person(name, age, dni, weight, height);

    System.out.println(personNoData);
    System.out.println(personBasicData);
    System.out.println(personFullData);
  }
}
