package introductionJava.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
  int id;
  int category;
  String DNI;
  String name;
  String lastName;
  int age;
  int phone;
  int emergencyPhone;
  String bloodType;

  User(
    int id,
    int category,
    // String DNI,
    String name,
    // String lastName,
    int age
    // int phone,
    // int emergencyPhone,
    // String bloodType
  ) {
    this.id = id;
    this.category = category;
    // this.DNI = DNI;
    this.name = name;
    // this.lastName = lastName;
    this.age = age;
    // this.phone = phone;
    // this.emergencyPhone = emergencyPhone;
    // this.bloodType = bloodType;
  }

  @Override
  public String toString() {
    // return ("id" + this.id + " " + category + " " + DNI);

    return (
      "ID " +
      id +
      " Category " +
      category +
      // DNI +
      " Name " +
      name +
      // lastName +
      " Age " +
      age +
      // phone +
      // emergencyPhone +
      // bloodType
      " \n "
    );
  }
}

public class Jungle_Race {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Map<Integer, Object> users = new HashMap<>();
    String[] categories = {
      "Circuito Chico",
      "Circuito Medio",
      "Circuito Avanzado",
    };

    ArrayList<User> users = new ArrayList<>();

    System.out.print("How many people will participate?: ");
    int quantityOfUsers = sc.nextInt();

    for (int i = 0; i < quantityOfUsers; i++) {
      System.out.println("/////////////// \n");
      System.out.print("What's your category?:  \n ");
      System.out.print("Circuito chico: 2 km: Press 1 \n ");
      System.out.print("Circuito medio: 5 km: Press 2 \n ");
      System.out.print(
        "Circuito Avanzado: 10 km (You need to have 18 years old): Press 3 \n "
      );
      int categoryUser = sc.nextInt();

      // System.out.print("What's your DNI?:  ");
      // String DNI = sc.next();
      System.out.print("What's your name?:  ");
      String name = sc.next();
      // System.out.print("What's your last name?:  ");
      // String lastName = sc.next();
      System.out.print("What's your age?:  ");
      int age = sc.nextInt();

      if (categoryUser == 3 && age < 18) {
        System.out.println("You need to have 18 years old or more.");
        continue;
      }

      // System.out.print("What's your phone?:  ");
      // int phone = sc.nextInt();
      // System.out.print("What's your emergency phone?:  ");
      // int emergencyPhone = sc.nextInt();
      // System.out.print("What's your blood type?:  ");
      // String bloodType = sc.next();

      users.add(
        new User(
          i,
          categoryUser,
          // DNI,
          name,
          // lastName,
          age
          // phone,
          // emergencyPhone,
          // bloodType
        )
      );
    }

    int options;
    int optionsDelete;

    do {
      System.out.println("\n");
      System.out.print("Select a category to show participants: \n");
      System.out.print("Circuito chico: 2 km: Press 1 \n ");
      System.out.print("Circuito medio: 5 km: Press 2 \n ");
      System.out.print("Circuito Avanzado: 10 km: Press 3 \n ");

      System.out.print("If you want to out: Press: 0 \n");
      options = sc.nextInt();
      if (users.size() > 0) {
        for (User user : users) {
          if (options != 0 && user.category == options) {
            System.out.println(
              "Category: " +
              categories[options - 1] +
              " Participant: " +
              user +
              "\n"
            );
          }
        }
      } else {
        System.out.println("This category doesn't have participants \n");
      }
    } while (options != 0);

    do {
      System.out.println("--- \n");
      System.out.println("Do you want to delete a participant? Press: 1 \n");
      System.out.println(" or Press enter to continue 0 \n");
      optionsDelete = sc.nextInt();
      if (optionsDelete == 1) {
        System.out.println("To delete a participant, press its ID number \n");
        int indexParticipant = sc.nextInt();
        users.remove(indexParticipant);
        System.out.println(
          "Participant with ID " + indexParticipant + " was deleted.\n"
        );
      }
    } while (optionsDelete != 0);

    for (User user : users) {
      double totalToPay = calculateBono(user.category, user.age);
      System.out.println(
        "Participant in category: " +
        categories[user.category - 1] +
        " with name: " +
        user.name +
        " must pay " +
        totalToPay
      );
    }
  }

  public static int calculateBono(int category, int age) {
    switch (category) {
      case 1:
        if (age <= 18) {
          return (1300);
        }
        return 1500;
      case 2:
        if (age <= 18) {
          return 2000;
        }
        return 2300;
      case 3:
        return 200;
      default:
        return 0;
    }
  }
}
