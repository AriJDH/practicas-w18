package model;

import interfaces.Student;
import interfaces.Support;
import interfaces.Teacher;

public class User implements Student, Support, Teacher {
  private String name;
  private String position;

  public User(String name, String position) {
    this.name = name;
    this.position = position;
  }

  @Override
  public void doSupport() {
    // TODO Auto-generated method stub
    System.out.println("I'm doing support");
  }

  @Override
  public void teach() {
    // TODO Auto-generated method stub
    System.out.println("I'm teaching");
  }

  @Override
  public void study() {
    // TODO Auto-generated method stub

    System.out.println("I'm studying");
  }
}
