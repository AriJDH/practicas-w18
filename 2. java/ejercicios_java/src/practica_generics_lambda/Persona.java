package practica_generics_lambda;

public class Persona {

    private String nombre;

    private String numeroIdentificacion;

    private int celular;

    private Boolean isCasado;

    private Double dinero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public Boolean getCasado() {
        return isCasado;
    }

    public void setCasado(Boolean casado) {
        isCasado = casado;
    }

    public Double getDinero() {
        return dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", celular=" + celular +
                ", isCasado=" + isCasado +
                ", dinero=" + dinero +
                '}';
    }
}
