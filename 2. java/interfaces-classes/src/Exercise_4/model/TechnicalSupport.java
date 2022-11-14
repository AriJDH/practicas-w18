package model;

public class TechnicalSupport extends User {

  public TechnicalSupport(String name, String position) {
    super(name, position);
  }

  @Override
  public void study() {
    // TODO Auto-generated method stub
    super.study();
  }

  @Override
  public void doSupport() {
    System.out.println("I can do Support.");
  }
}
