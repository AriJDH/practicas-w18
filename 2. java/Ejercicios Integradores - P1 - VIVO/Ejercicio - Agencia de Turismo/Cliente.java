public class Cliente {

    private String nombre;
    private String apellido;
    private String dni;

    private int cantHotel;
    private int cantViaje;

    private int cantLocalizadores;

    private int paquetesCompletos;

    public Cliente(){

    }

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public int getCantLocalizadores() {
        return cantLocalizadores;
    }

    public void setCantLocalizadores(int cantLocalizadores) {
        this.cantLocalizadores = cantLocalizadores;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCantHotel(int cantHotel) {
        this.cantHotel += cantHotel;
    }

    public int getCantHotel() {
        return this.cantHotel;
    }

    public void setCantViaje(int cantViaje) {
        this.cantViaje += cantViaje;
    }

    public int getCantViaje(){
        return this.cantViaje;
    }

    public void setPaquetesCompletos(int paquetesCompletos) {
        this.paquetesCompletos = paquetesCompletos;
    }

    public int getPaquetesCompletos() {
        return this.paquetesCompletos;
    }

    public String toString() {
        return "Datos personales: " + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "D.N.I: " + this.dni;
    }
}
