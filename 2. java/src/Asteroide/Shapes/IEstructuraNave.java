package Asteroide.Shapes;

import java.util.List;

public interface IEstructuraNave {

    public void add(IEstructuraNave nave);
    public String getNombre();
    public void setPuntuacion();
    public int getPuntaje();
    public void setCordenadas(List<Integer> coordenadas);
    public float calcularDistancia(List<Integer> coordenadas);

}
