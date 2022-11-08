public class Reserva {

    private Double costo;
    private String nombre;

    public Reserva(Double costo, String nombre) {
        this.costo = costo;
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
