import java.util.List;

public class Asteroide {

    private int coordX;
    private int coordY;

    public Asteroide(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public void setCoordenadasAsteroid(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return this.coordX;
    }

    public int getCoordY() {
        return this.coordY;
    }




}
