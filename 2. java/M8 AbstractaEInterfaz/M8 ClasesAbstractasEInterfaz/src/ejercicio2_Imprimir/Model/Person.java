package ejercicio2_Imprimir.Model;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private String dni;


    public Person() {
    }

    public Person(String name, String lastName, int age, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "{ "+name + " " + lastName +
                ", age:" + age +
                ", dni:" + dni  +
                " }";
    }
}
