package ejercicio_5_asteroid;

public class Jugador {
    String name;
    Double puntuacion = 0.0;
    Nave nave;

    public Jugador(String name, Nave nave) {
        this.name = name;
        this.nave = nave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
