import clases.Juego;

public class Test {
    public static void main(String[] args) {
        Juego juego = new Juego("Asteroid");

        juego.inscribirJugadores("Jonathan", 2, "LA Nave");
        juego.inscribirJugadores("Leila", 1, "MELI");
        juego.inscribirJugadores("Carolina", 1, "NAVE PC");
        juego.inscribirJugadores("Eloisa", 2, "GOL TREND");

        System.out.println(" ");

        juego.mostrarJugadores();
        juego.iniciarJuego(50, 12);
        juego.iniciarJuego(20, 24);
        juego.iniciarJuego(10, 80);
        juego.iniciarJuego(30, 70);

        juego.terminarJuego();
    }

}
