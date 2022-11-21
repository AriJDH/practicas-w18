import java.util.ArrayList;

public class TemperaturaGlobal {
    private ArrayList<Temperatura> tempsCiudades;

    public TemperaturaGlobal(ArrayList<Temperatura> temCiudad) {
        this.tempsCiudades = temCiudad;
    }

    public ArrayList<Temperatura> getTemCiudad() {
        return tempsCiudades;
    }

    public void setTemCiudad(ArrayList<Temperatura> tempsCiudades) {
        this.tempsCiudades = tempsCiudades;
    }

    public Temperatura getTemGlobalMax(){
        int comparadorMaxTemp = this.tempsCiudades.get(0).getMaxTemp();
        Temperatura ciuConMaxTem = new Temperatura();
        for(Temperatura tempCiudad: tempsCiudades) {
            if (tempCiudad.getMaxTemp() >= comparadorMaxTemp){
                comparadorMaxTemp = tempCiudad.getMaxTemp();
                ciuConMaxTem = tempCiudad;
            }
        }
        return ciuConMaxTem;
    }

    public Temperatura getTemGlobalMin(){
        int comparadorMinTemp = this.tempsCiudades.get(0).getMinTemp();
        Temperatura ciuConMinTem = new Temperatura();
        for(Temperatura tempCiudad: tempsCiudades) {
            if (tempCiudad.getMinTemp() <= comparadorMinTemp){
                comparadorMinTemp = tempCiudad.getMinTemp();
                ciuConMinTem = tempCiudad;
            }
        }
        return ciuConMinTem ;
    }

}
