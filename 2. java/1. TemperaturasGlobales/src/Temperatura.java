
public class Temperatura {
    private String ciudad;
    private int maxTemp;
    private int minTemp;

    public Temperatura() {

    }

    public Temperatura(String ciudad, int maxTemp, int minTemp) {
        this.ciudad = ciudad;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }



}


