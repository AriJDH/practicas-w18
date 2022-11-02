package clases;

public class Jugador {
    private String nombre;
    private Nave nave;

    public Jugador(String nombre, int eleccion, String nombreNave) {
        this.nombre = nombre;
        elegirNave(eleccion, nombreNave);
    }
    public void elegirNave(int eleccion, String nombre){
        if (eleccion == 1){
            this.nave = new NaveSimple(nombre);
        }else if(eleccion == 2){
            this.nave = new FlotaDeNavesSimples(nombre);
        }
    }

    public double jugar(double x, double y){
        return this.nave.mover(x, y);
    }

    @Override
    public String toString() {
        return "\r\n" +
                " Nombre= " + nombre  +
                "|| Nave= " + this.nave.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarPunto(){
        this.nave.sumarPunto();
    }

    public double puntosJugador(){
        return this.nave.getPuntos();
    }

}
