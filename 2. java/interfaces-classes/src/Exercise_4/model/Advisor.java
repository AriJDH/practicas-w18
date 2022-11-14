package model;

public class Advisor extends User {

  public Advisor(String name, String position) {
    super(name, position);
  }

  @Override
  public void study() {
      // TODO Auto-generated method stub
      super.study();
  }

  @Override
  public void teach() {
    System.out.println("I'm an Advisor and I teach to other students.");
  }
}
