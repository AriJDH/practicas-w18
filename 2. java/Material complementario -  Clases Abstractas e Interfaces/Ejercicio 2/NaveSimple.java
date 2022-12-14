import java.util.List;

public class NaveSimple implements CalculoDistancia{

    private String nombre;
    private int coordX;
    private int coordY;
    private int puntuacion;

    private double distancia;

    public NaveSimple(String nombre, int coordX, int coordY, int puntuacion){
        this.nombre = nombre;
        this.coordX = coordX;
        this.coordY = coordY;
        this.puntuacion = puntuacion;
        this.distancia = 0;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCoordenadasNave(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion += puntuacion;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getCoordX() {
        return this.coordX;
    }

    public int getCoordY() {
        return this.coordY;
    }

    public int getPuntuacion(){
        return this.puntuacion;
    }

    public double getDistancia() {
        return this.distancia;
    }

    //Sobreescribo metodo del calculo de la distancia entre coordenadas
    @Override
    public double calcularDistancia(NaveSimple nave, Asteroide asteroid) {
        return Math.sqrt(Math.pow((nave.getCoordX() - asteroid.getCoordX()),2) + Math.pow((nave.getCoordY() - asteroid.getCoordY()),2));
    }

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + "\n" +
                "Puntuacion obtenida: " + this.getPuntuacion();
    }



}
