package Abstract;

import Interface.PersonaEspecializada;

public abstract class Persona implements PersonaEspecializada {

    private String nombreApellido;
    private String areaTrabajo;
    private String cargo;

    public Persona(String nombreApellido, String areaTrabajo, String cargo) {
        this.nombreApellido = nombreApellido;
        this.areaTrabajo = areaTrabajo;
        this.cargo = cargo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isTecnico(){
        if (cargo == "Tecnico")return true;
        else return false;
    }

    public boolean isTutor(){
        if (cargo == "Tutor")return true;
        else return false;
    }

    public abstract String ejercerCargo();


}
