package Ejercicio2Asteroid.Interfaces;

public interface INave {
    public void add(INave nave);
    public String getNombre();
    public void setPuntuacion();
    public int getPuntuacion();
    public float calcularDistancia(int[] coordenadas);
}
