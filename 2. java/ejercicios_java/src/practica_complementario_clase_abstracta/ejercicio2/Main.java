package practica_complementario_clase_abstracta.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Asteroide> coordenadasAsteroides = new ArrayList<>();

        coordenadasAsteroides.add(new Asteroide(12,2));

        Participante participante = new Participante();
        participante.setCoordenadasAsteroides(coordenadasAsteroides);

        participante.cargarNaves(new NaveSimple("nave dizzi", 12, 1),
                new ContenedorNaves(
                        new NaveSimple("Nave tren", 13, 12),
                        new NaveSimple("Nave valencia", 22, 10)
                ));

        participante.empezarJuego();
    }
}
