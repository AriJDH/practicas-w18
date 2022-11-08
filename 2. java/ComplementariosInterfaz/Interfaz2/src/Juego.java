import java.util.ArrayList;
import java.util.List;

public class Juego {
    List<Asteroide> asteroides;
    List<Jugador> jugadores;

    public Juego(){}
    public void iniciarJuego(){
        int x=0;
        int y=0;
        int cantidad = (int)(Math.random() * 5);
        List<Asteroide> ast = new ArrayList<Asteroide>();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        List<Nave> naves = new ArrayList<Nave>();
        Flota flota;
        Defensa def = new Defensa();
       for (int j=0;j<cantidad*(int)(Math.random() * 5);j++){
           for(int i=0; i<cantidad; i++ ){
               x = (int)(Math.random() * 10);
               y = (int)(Math.random() * 10);

               Coordenada c = new Coordenada(x,y);
               Asteroide a = new Asteroide(c);
               ast.add(a);

               Nave nave = new Nave("n"+i, c);
               def.setNave(nave);
               naves.add(nave);
           }
           x = (int)(Math.random() * 10);
           y = (int)(Math.random() * 10);

           Coordenada c = new Coordenada(x,y);
           Asteroide a = new Asteroide(c);
           ast.add(a);
           Nave nave2 = new Nave("n"+j, c);
           Jugador jugador = new Jugador(def,0,j);
           naves.add(nave2);
           flota = new Flota(naves);
           jugadores.add(jugador);
       }
      this.setAsteroides(ast);
      this.setJugadores(jugadores);

    }
    public Jugador ganador(){
        double mayor=0;
        double distancia = 0;
        Jugador jugadorGanador = new Jugador();
        List<Double> historial = new ArrayList<Double>();
        for(Jugador j: this.jugadores) {
            if (j.getDefensa().getFlota() != null) {
                for (Asteroide as : this.asteroides) {
                    distancia = j.getDefensa().getFlota().calcularDistancia(as);
                    historial.add(distancia);
                    if (mayor < distancia) {
                        mayor = distancia;
                        jugadorGanador = j;
                    }
                }
            }
            for (Asteroide as : this.asteroides) {
                distancia = j.getDefensa().getNave().calcularDistancia(as);
                historial.add(distancia);
                if (mayor < distancia) {
                    mayor = distancia;
                    jugadorGanador = j;
                }
                jugadorGanador.setPuntaje(jugadorGanador.puntaje + 1);
            }
            j.getDefensa().setHistorialDistancias(historial);
        }

            return  jugadorGanador;
    }
    public void mostrarGanador(Jugador j){

            System.out.println("-----------------------------******----------------------------");
            System.out.println("-----------------------------******----------------------------");
            System.out.println("------------------El ganador es: ----------------------");
            System.out.println("Jugador " + j.getPos());
            System.out.println(j.toString());
    }

    public void mostrarHistorial (){
        for(Jugador j: this.jugadores){
            for(Double d: j.getDefensa().getHistorialDistancias()){
                System.out.println("Historico de Distancias-> Jugador: "+j.toString());
                System.out.println("Asteroide-> " + this.getAsteroides().toString());
                System.out.println(d.doubleValue());
            }
        }
    }

    public Juego(List<Asteroide> asteroides, List<Jugador> jugadores) {
        this.asteroides = asteroides;
        this.jugadores = jugadores;
    }

    public List<Asteroide> getAsteroides() {
        return asteroides;
    }

    public void setAsteroides(List<Asteroide> asteroides) {
        this.asteroides = asteroides;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
