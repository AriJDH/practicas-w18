package ejercicio2_Imprimir.Model;

import ejercicio2_Imprimir.Interfaz.Printable;

import java.util.List;

public class Curriculum implements Printable {
    private Person person;
    List<Skill> skillList;

    public Curriculum() {
    }

    public Curriculum(Person person, List<Skill> skillList) {
        this.person = person;
        this.skillList = skillList;
    }

    public Person getPersona() {
        return person;
    }

    public void setPersona(Person person) {
        this.person = person;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Cv  \t\t" + person +
                " · Habilidades:" + skillList.toString() +
                '}';
    }

}
