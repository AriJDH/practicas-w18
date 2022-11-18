package supermercado_el_economico.model;

public class Cliente {

    private String dni;
    private String nombreCompleto;

    public Cliente(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }


    @Override
    public String toString() {
        return "Cliente: " +
                "dni = " + dni+
                "- Nombre Completo = " + nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
