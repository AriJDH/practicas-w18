package ejercicio2;

import java.util.List;

public class Curriculum implements Printable {

    // Atributos
    private String name;
    private String lastname;
    private Integer dni;
    private String adress;
    private List<String> skills;

    // Constructores
    public Curriculum(String nombre, String apellido) {
    }

    public Curriculum(String name, String lastname, Integer dni, String adress, List<String> skills) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.adress = adress;
        this.skills = skills;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    // To String
    @Override
    public String toString() {
        return "Curriculum{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + dni +
                ", adress='" + adress + '\'' +
                ", skills=" + skills +
                '}';
    }

}
