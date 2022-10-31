package Ejercicio2.modal;

public class Person {

    private String name;
    private String lastName;
    private int years;

    public Person(String name, String lastName, int years) {
        this.name = name;
        this.lastName = lastName;
        this.years = years;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", years=" + years +
                '}';
    }
}
