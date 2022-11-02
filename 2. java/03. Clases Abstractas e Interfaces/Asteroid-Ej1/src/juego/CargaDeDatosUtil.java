package juego;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargaDeDatosUtil {
    private final String RUTA_NOMBRES= "jugadores.txt";
    private final String RUTA_NAVES= "naves.txt";
    private final int MIN_COORDENADAS= 0;
    private final int MAX_COORDENADAS= 200;
    private List<String> nombres;
    private List<String> naves;

    public CargaDeDatosUtil() {
        this.nombres = leerArchivo(RUTA_NOMBRES);
        this.naves = leerArchivo(RUTA_NAVES);
    }

    private List<String> leerArchivo(String ruta) {
        List<String> lista = new ArrayList<>();
        try {
            File archivo = new File(ruta);
            Scanner sc = new Scanner(archivo);
            while(sc.hasNext()){
                lista.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.getStackTrace();
        }
        return lista;
    }

    public Nave getNaveRandom() {
        return new Nave(getNombreNave(), getCoordenadaRandom());
    }

    public Coordenada getCoordenadaRandom() {
        return new Coordenada(getRandomNroCoordenadas(), getRandomNroCoordenadas());
    }

    public double getRandomNroCoordenadas() {
        return getNroRandom(MIN_COORDENADAS, MAX_COORDENADAS);
    }

    public double getNroRandom(double min, double max) {
        return (Math.random() * (max-min+1)) + min;
    }

    public String getNombreNave() {
        return this.naves.get((int) (getNroRandom(0, this.naves.size()-1)));
    }

    public List<String> getNombres() {
        return nombres;
    }

}

