package org.example;

/**
 * Class that represents a person
 *
 * @author Juan Pablo Agudelo Florez
 **/
public class Person {
    private String dni;
    private String name;
    private int age;
    private float weight;
    private float height;

    public Person() {
    }

    public Person(String dni, String name, int age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
    }

    public Person(String dni, String name, int age, float weight, float height) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    /**
     * Method responsible for returning the IMC
     *
     * @return int - example: {-1: Bajo peso, 0: Peso saludabe, 1: Sobrepeso}
     */
    public int ImcCalculate() {
        float imc = weight / (height * height);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Method responsible for returning if the person is of legal age
     *
     * @return boolean
     */
    public boolean IsOlder() {
        return age >= 18 ? true : false;
    }

    @Override
    public String toString() {
        return "Person{" + "dni='" + dni + '\'' + ", name='" + name + '\'' + ", age=" + age + ", weight=" + weight + ", height=" + height + '}';
    }
}
