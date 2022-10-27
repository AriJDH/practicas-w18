package models;

public class Persona {

    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Persona() {
    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int calcularIMC() {
        double imc = getWeight()/(getHeight()*getHeight());
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad () {
        if (getAge() >= 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + this.name + ", Edad: " + this.age + ", D.N.I.: " + this.dni + ", Peso: " +
                this.weight + ", Altura: " + this.height;
    }
}
