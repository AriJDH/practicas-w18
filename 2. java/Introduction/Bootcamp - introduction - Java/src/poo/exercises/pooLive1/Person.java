package poo.exercises.pooLive1;

public class Person {
  String name;
  int age;
  String dni;
  double weight;
  double height;

  public Person(String name, int age, String dni) {
    this.name = name;
    this.age = age;
    this.dni = dni;
  }

  public Person() {
    this.name = name;
    this.age = age;
    this.dni = dni;
    this.weight = weight;
    this.height = height;
  }

  public Person(
    String name,
    int age,
    String dni,
    double weight,
    double height
  ) {
    this.name = name;
    this.age = age;
    this.dni = dni;
    this.weight = weight;
    this.height = height;
  }

  public double cacularIMC() {
    double IMC =
      this.weight / (Math.pow(this.height, 2)) - this.weight - this.height;

    if (IMC < 20) {
      return -1;
    } else if (IMC >= 20 && IMC <= 25) {
      return 0;
    } else {
      return 1;
    }
  }
}
