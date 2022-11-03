package ejercicio4_comp_Universidad.Model;

public abstract class Persona {
    private String name;
    private static int nextNroLegajo = 1;
    private int nroLegajo;

    public Persona(String name) {
        this.name = name;
        nroLegajo = nextNroLegajo++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo++;
    }


    @Override
    public String toString() {
        return
                "\t" + name + " ·" + " Legajo: " + getNroLegajo();
    }
}
