package org.ml;


public class Persona {

    private String name;
    private int age;
    private String DNI;
    private double height;
    private double weight;

    public Persona(String name, int age, String DNI) {
        this.name = name;
        this.age = age;
        this.DNI = DNI;
    }

    public Persona(String name, int age, String DNI, double height, double weight) {
        this.name = name;
        this.age = age;
        this.DNI = DNI;
        this.height = height;
        this.weight = weight;
    }

    public Persona() {
    }

    public Integer calcularIMC() {
        double IMC = this.weight / Math.pow(this.height, 2) - (this.weight + this.height);
        if (IMC < 20)
           return -1;
        else if (IMC > 20 && IMC <= 25)
           return 0;
        else
           return 1;
    }

    public Boolean esMayorDeEdad(){
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Persona {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", DNI='" + DNI + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
