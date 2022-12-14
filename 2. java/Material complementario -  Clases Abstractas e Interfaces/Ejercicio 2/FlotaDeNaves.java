import java.util.ArrayList;
import java.util.List;

public class FlotaDeNaves implements CalculoDistancia{

    private List<NaveSimple> navesSimples;
    private double promedio;

    private int puntuacion;

    public FlotaDeNaves(List<NaveSimple> navesSimples){
        this.navesSimples = navesSimples;
        this.promedio = 0;
        this.puntuacion = 0;
    }

    public List<NaveSimple> getNavesSimples() {
        return navesSimples;
    }

    public void setPromedio(double promedio){
        this.promedio = promedio;
    }

    public double getPromedio() {
       return this.promedio;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion += puntuacion;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }



    @Override
    public double calcularDistancia(NaveSimple nave, Asteroide asteroid) {
        return  Math.sqrt(Math.pow((nave.getCoordX() - asteroid.getCoordX()),2) + Math.pow((nave.getCoordY() - asteroid.getCoordY()),2));
    }

    public double calcularPromedio( Asteroide asteroide){
        double distancias = 0;
        for(int i=0; i<this.navesSimples.size(); i++){
            //System.out.println("Distancia " + i + " :" + this.navesSimples.get(i).calcularDistancia(this.navesSimples.get(i), asteroide));
            distancias += this.navesSimples.get(i).calcularDistancia(navesSimples.get(i), asteroide);
        }
        return distancias/this.navesSimples.size();
    }

    @Override
    public String toString() {
        return "Nombre: " + this.navesSimples.get(0).getNombre() + "\n" +
                "Puntuacion obtenida: " + this.getPuntuacion();

    }



}
