import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {
    String nombre, apellido;
    List<String> atributos= new ArrayList<>();

    @Override
    public void imprimir() {
        System.out.println("Imprimendo el curriculum de "+this.nombre+" "+this.apellido);
    }

    public Curriculum(String nombre, String apellido, List<String> atributos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.atributos = atributos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<String> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", atributos=" + atributos +
                '}';
    }
}
