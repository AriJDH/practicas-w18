import java.util.List;

public class Nave implements Idefensa {
    String nombre;
    Coordenada coordenada;

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", coordenada=" + coordenada +
                '}';
    }

    public Nave(String nombre, Coordenada coordenada) {
        this.nombre = nombre;
        this.coordenada = coordenada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public double calcularDistancia(Asteroide asteroide){
        double rta=0;
        double a = Math.pow(this.coordenada.x - asteroide.getCoordenadas().x,2);
        double b = Math.pow(this.coordenada.y - asteroide.getCoordenadas().y,2);
        rta = Math.sqrt(a+b);
        return rta;
    }
}
