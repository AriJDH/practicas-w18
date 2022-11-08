public class Jugador {
    Defensa defensa;
    int puntaje;

    int pos;

    public Jugador(Defensa defensa, int puntaje, int pos) {
        this.defensa = defensa;
        this.puntaje = puntaje;
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "defensa=" + defensa +
                ", puntaje=" + puntaje +
                ", pos=" + pos +
                '}';
    }

    public int calcularPuntaje(){
        int rta=0;
        return rta;
    }

    public Jugador(){}
    public Jugador(Defensa defensa, int puntaje) {
        this.defensa = defensa;
        this.puntaje = puntaje;
    }

    public Defensa getDefensa() {
        return defensa;
    }

    public void setDefensa(Defensa defensa) {
        this.defensa = defensa;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
