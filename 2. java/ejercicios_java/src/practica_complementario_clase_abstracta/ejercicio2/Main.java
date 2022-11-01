package practica_complementario_clase_abstracta.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Asteroide> coordenadasAsteroides = new ArrayList<>();

        coordenadasAsteroides.add(new Asteroide(12,2));
        coordenadasAsteroides.add(new Asteroide(0,2));

        List<Participante> participantes = new ArrayList<>();

        Participante participante = new Participante();

        participante.cargarNaves(new NaveSimple("nave dizzi", 12, 1),
                new ContenedorNaves(
                        new NaveSimple("Nave tren", 13, 12),
                        new NaveSimple("Nave valencia", 22, 10)
                ));

        Participante participante2 = new Participante();
        participante2.cargarNaves(new NaveSimple("Nave dizzi 2", 2, 1));

        participantes.add(participante);
        participantes.add(participante2);

        Juego juego = new Juego();
        juego.setParticipantes(participantes);
        juego.setCoordenadasAsteroides(coordenadasAsteroides);

        juego.empezarJuego();

    }
}
