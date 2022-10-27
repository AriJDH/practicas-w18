package poo.exercises.pooLive1;

public class Main {
   public static void main(String[] args) {
    Person personNoData = new Person();
    Person personBasicData = new Person("angel",23,null); // ¿Qué sucede si tratamos de hacer esto? Se colocan valores nulos por defecto o tira un error 
    Person personFullData = new Person("angel", 23, "102020", 95,1.75);

    System.out.println(personFullData.cacularIMC());
   }
}
