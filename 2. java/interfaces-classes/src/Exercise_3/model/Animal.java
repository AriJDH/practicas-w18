package model;

public abstract class Animal {

  abstract void soundOfAnimal();

  abstract void eat();

  public static void eatAnimal(Animal animal) {
    animal.eat();
  }
}
