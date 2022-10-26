import Temperatura.TemperaturaGlobal;

public class Main {
    public static void main(String[] args) {
        TemperaturaGlobal temps= new TemperaturaGlobal();
        //temps.obtenerTemperaturasCiudad();
        temps.mostrarCiudadConMinima();
        temps.mostrarCiudadConMaxima();
    }
}