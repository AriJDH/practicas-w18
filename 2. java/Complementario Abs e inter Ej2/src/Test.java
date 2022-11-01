import clases.Juego;

public class Test {
    public static void main(String[] args) {
        Juego juego = new Juego("Asteroid");

        juego.inscribirJugadores("Jonathan", 2, "Cuarenta");
        juego.inscribirJugadores("Leila", 1, "Suavecito");
        juego.inscribirJugadores("Carolina", 1, "Electrodomesticos");
        juego.inscribirJugadores("Eloisa", 2, "Cristina");


        juego.iniciarJuego(50, 50);
    }

}
