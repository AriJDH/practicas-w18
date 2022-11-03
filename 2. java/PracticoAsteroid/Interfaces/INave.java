package Interfaces;

public interface INave {

    public void add(INave nave);
    public String getNombre();
    public void setPuntuacion();
    public int getPuntaje();
    public float calcularDistancia(int[] coord);
}
