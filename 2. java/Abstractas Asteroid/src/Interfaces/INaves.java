package Interfaces;

public interface INaves {
    public double calcularDistancia(int xBlanco, int yBlanco);
    public void setPuntuacion();
    public  String getNombre(); //Se debieron definir aqui para que me deje sacarlos en el main en la lista de INaves
    public String getCoordenadas();
}
