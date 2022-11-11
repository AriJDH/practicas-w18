package ClasesAbsInterfaceDocumentos.Class;

import ClasesAbsInterfaceDocumentos.Interface.IDocumento;

import java.util.ArrayList;

public class Curriculums implements IDocumento {
    private Persona persona;
    private ArrayList<Habilidad> habilidadList;

    public Curriculums(Persona persona, ArrayList<Habilidad> habilidadList) {
        this.persona = persona;
        this.habilidadList = habilidadList;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "persona=" + persona +
                ", habilidadList=" + habilidadList +
                '}';
    }

    @Override
    public void imprimirDocumento() {
        System.out.println(toString());
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArrayList<Habilidad> getHabilidadList() {
        return habilidadList;
    }

    public void setHabilidadList(ArrayList<Habilidad> habilidadList) {
        this.habilidadList = habilidadList;
    }
}
