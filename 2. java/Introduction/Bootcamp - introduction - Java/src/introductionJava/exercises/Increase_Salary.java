package introductionJava.exercises;

import java.util.Scanner;

public class Increase_Salary {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese su DNI: ");

    int idEmployee = sc.nextInt();

    System.out.print("Ingrese su Salario: ");

    double salaryOfEmployee = sc.nextDouble();
    double salaryWithBonus = 0;

    if (salaryOfEmployee > 20000 && salaryOfEmployee <= 45000) {
      salaryWithBonus = calculatePercent(salaryOfEmployee, 0.10);
    } else if (salaryOfEmployee > 45000) {
      salaryWithBonus = calculatePercent(salaryOfEmployee, 0.05);
    } else if (salaryOfEmployee <= 20000) {
      salaryWithBonus = calculatePercent(salaryOfEmployee, 0.20);
    }

    System.out.println(
      "Para el empleado con el ID: " +
      idEmployee +
      " Con sueldo de: " +
      salaryOfEmployee +
      " Su salario con el bono es: " +
      salaryWithBonus
    );
  }

  public static double calculatePercent(double salary, double percent) {
    return salary + (salary * percent);
  }
}
