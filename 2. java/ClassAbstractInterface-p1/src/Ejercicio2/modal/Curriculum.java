package Ejercicio2.modal;

import Ejercicio2.Interface.Printable;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Printable {

    private Person person;
    private List<String> skills=new ArrayList<>();

    public Curriculum(Person person, List<String> skills) {
        this.person = person;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "person=" + person +
                ", skills=" + skills.toString() +
                '}';
    }
}
