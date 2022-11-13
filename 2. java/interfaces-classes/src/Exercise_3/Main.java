import model.Animal;
import model.Cat;
import model.Cow;
import model.Dog;

public class Main {

  public static void main(String[] args) {
    Cow cow1 = new Cow();
    Cat cat1 = new Cat();
    Dog dog1 = new Dog();

    cow1.eatHerb();
    cow1.soundOfAnimal();

    cat1.eatMeat();
    cat1.soundOfAnimal();

    dog1.eatMeat();
    dog1.soundOfAnimal();

    Animal.eatAnimal(cow1);
    Animal.eatAnimal(cat1);
    Animal.eatAnimal(dog1);
  }
}
