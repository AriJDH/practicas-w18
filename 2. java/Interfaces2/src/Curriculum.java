import java.util.List;

public class Curriculum extends Persona implements Imprimible {
    List<String> habilidades;

    public Curriculum(String nombre, int edad, int dni, List<String> habilidades) {
        super(nombre, edad, dni);
        this.habilidades = habilidades;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "habilidades=" + habilidades +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                '}';
    }

    @Override
    public void imprimir(Object o) {
        System.out.println(o.toString());
    }
}
