package poo.exercises.pooLive1;

import java.text.DecimalFormat;

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

  public double calculateIMC() {
    DecimalFormat df = new DecimalFormat("#.00");
    double IMC = Double.parseDouble(
      df.format(this.weight / (Math.pow(this.height, 2)))
    );

    if (IMC < 20) {
      return -1;
    } else if (IMC >= 20 && IMC <= 25) {
      return 0;
    } else {
      return 1;
    }
  }

  public String calculateAge() {
    if (this.age <= 18) {
      return "Young";
    } else if (this.age > 30 && this.age < 18) {
      return "Adult";
    } else {
      return "Old";
    }
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    if (this.name == null) {
      return "This person doesn't have data.";
    } else if (this.dni == null) {
      return (
        "HI: " +
        this.name +
        " and Your IMC: " +
        calculateIMC() +
        " and you are: " +
        calculateAge() +
        " with " +
        this.age
      );
    } else {
      return (
        "HI: " +
        this.name +
        " Your DNI is: " +
        this.dni +
        " Your IMC: " +
        calculateIMC() +
        " and you are: " +
        calculateAge() +
        " with " +
        this.age
      );
    }
  }
}
