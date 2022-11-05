package Universidad.CAbstracta;

public abstract class Estudiante extends Persona {

    String Curso;
    int Semestre;

    public Estudiante(String nombre, int edad, String curso, int semestre) {
        super(nombre, edad);
        this.setCurso(curso);
        this.setSemestre(semestre);
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int semestre) {
        Semestre = semestre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "Nombre='" + getNombre() + '\'' +
                ", Edad=" + getEdad() +
                ", Curso='" + getCurso() + '\'' +
                ", Semestre=" + getSemestre() +
                '}';
    }
}
