package Asteroide.Shapes;

import java.util.List;

public interface IEstructuraNave {

    public void agregarNave(IEstructuraNave nave);
    public String getNombreNave();
    public void setNombreNave(String nombreNave);
    public void setPuntuacion();
    public int getPuntaje();
    public void setCordenadasNave(List<Integer> coordenadasNave);
    public void setCordenadasAsteroide(List<Integer> coordenadasAsteroide);
    public float calcularDistancia();

}
