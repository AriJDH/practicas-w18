package model;

import interfaces.Herbivores;

public class Cow extends Animal implements Herbivores {

  @Override
  public void eatHerb() {
    System.out.println(
      "I'm a " + this.getClass().getSimpleName() + " I'm eating Herb"
    );
  }

  @Override
  public void soundOfAnimal() {
    System.out.println("Muuu!!");
  }

  @Override
  void eat() {
    eatHerb();
  }
}
