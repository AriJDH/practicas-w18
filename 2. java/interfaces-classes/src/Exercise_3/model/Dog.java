package model;

import interfaces.Carnivores;

public class Dog extends Animal implements Carnivores {

  @Override
  public void eatMeat() {
    System.out.println(
      "I'm a " + this.getClass().getSimpleName() + " I'm eating Meat"
    );
  }

  @Override
  public void soundOfAnimal() {
    System.out.println("Guau Guau!!");
  }

  @Override
  void eat() {
    eatMeat();
  }
}
