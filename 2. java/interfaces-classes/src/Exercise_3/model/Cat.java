package model;

import interfaces.Carnivores;

public class Cat extends Animal implements Carnivores {

  @Override
  public void soundOfAnimal() {
    System.out.println("Miau miau!!");
  }

  @Override
  public void eatMeat() {
    System.out.println(
      "I'm a " + this.getClass().getSimpleName() + " I'm eating Meat"
    );
  }

  @Override
  void eat() {
    eatMeat();
  }
}
