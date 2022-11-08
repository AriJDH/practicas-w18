package clase3_b_EjerComplementarios.Ej2;

public interface INave {
    public void add(INave nave);
    public String getNombre();
    public void setPuntuacion();
    public Integer getPuntaje();
    public double calcularDistancia(int x, int y);
}
