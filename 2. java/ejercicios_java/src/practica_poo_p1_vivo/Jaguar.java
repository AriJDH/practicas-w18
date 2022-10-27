package practica_poo_p1_vivo;

public class Jaguar {

    private String nombre;

    private String edad;

    private String sexo;

    private String lugarNacimiento;

    public Jaguar() {
    }

    public Jaguar(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    @Override
    public String toString() {
        return "Jaguar{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", sexo='" + sexo + '\'' +
                ", lugarNacimiento='" + lugarNacimiento + '\'' +
                '}';
    }
}
