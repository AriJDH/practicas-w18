public class Participante {



    //Varibales del participante
    Double DNI;
    String nombre;
    String apellido;
    int edad;
    double celular;
    double numEmergencia;
    String RH;

    //Getters y setters

    public Double getDNI() {
        return DNI;
    }

    public void setDNI(Double DNI) {
        this.DNI = DNI;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCelular() {
        return celular;
    }

    public void setCelular(double celular) {
        this.celular = celular;
    }

    public double getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(double numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    //Crear método
    public Participante(){

    }


    public Participante(double DNI, String nombre, String apellido, int edad, double celular, double numEmergencia, String RH){
        this.DNI= DNI;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.celular=celular;
        this.numEmergencia=numEmergencia;
        this.RH=RH;

    }

    public String mostrarParticipante(){
        System.out.println("La información del participante es:");
        String participanteX="DNI:"+ this.DNI + "NOMBRE: "+ this.nombre + "APELLIDO:" + this.apellido + " EDAD:" + this.edad + "CELULAR:" + this.celular +"NUMERO DE EMERGENCIA:"+ this.numEmergencia + "RH: "+ this.RH;
        return participanteX;
    }


}
