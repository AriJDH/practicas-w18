package ejercicio2.clases;

public class Habilidad {
    private String nombreHabilidad;

    public Habilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    @Override
    public String toString() {
        return nombreHabilidad;
    }
}
