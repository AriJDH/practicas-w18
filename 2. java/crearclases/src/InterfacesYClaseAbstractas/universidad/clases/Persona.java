package InterfacesYClaseAbstractas.universidad.clases;

public abstract class Persona {
    private String nombre;
    private String Apellido;
    private Integer dni;
    private String dirección;
    private String localidad;
    private String provincia;
    private String pais;

    public Persona(
            String nombre,
            String apellido,
            Integer dni,
            String dirección,
            String localidad,
            String provincia,
            String pais
    ) {
        this.nombre = nombre;
        Apellido = apellido;
        this.dni = dni;
        this.dirección = dirección;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", dni=" + dni +
                ", dirección='" + dirección + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'';
    }
}
