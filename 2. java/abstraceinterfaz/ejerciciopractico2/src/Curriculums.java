
import java.util.ArrayList;
import java.util.List;

public class Curriculums implements Documento{
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private List<String> habilidades;

    public Curriculums(){}
    public Curriculums(String nombre, String apellidoMaterno, String apellidoPaterno, List<String> habilidad){
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.habilidades = habilidad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimirDocumento(String tipoDocumento) {
        System.out.println("Tipo de documento: Curriculums");
    }

}
