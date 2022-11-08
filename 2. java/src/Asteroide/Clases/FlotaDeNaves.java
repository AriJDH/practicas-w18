package Asteroide.Clases;

import Asteroide.Shapes.IEstructuraNave;

import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.util.ArrayList;
import java.util.List;

public class FlotaDeNaves implements IEstructuraNave {
    public FlotaDeNaves() {
    }
    private String nombreNave;
    private List<IEstructuraNave> flotaNavesSiemples = new ArrayList<>();
    private List<Integer> coordenadasNave;
    private List<Integer> coordenadasAsteroide;
    private int puntaje;

    @Override
    public void agregarNave(IEstructuraNave nave) {
        this.flotaNavesSiemples.add(nave);
    }

    @Override
    public String getNombreNave() {
        return this.nombreNave;
    }

    @Override
    public void setNombreNave(String nombreNave) {
        this.nombreNave = nombreNave;
    }

    @Override
    public void setPuntuacion() {
        this.puntaje += 1;
    }

    @Override
    public int getPuntaje() {
        return this.puntaje;
    }

    @Override
    public void setCordenadasNave(List<Integer> coordenadasNave) {
        this.coordenadasNave = new ArrayList<>();
        this.coordenadasNave = coordenadasNave;
    }

    @Override
    public void setCordenadasAsteroide(List<Integer> coordenadasAsteroide) {
        this.coordenadasAsteroide = new ArrayList<>();
        this.coordenadasAsteroide = coordenadasAsteroide;
    }

    @Override
    public float calcularDistancia() {
        float distancia=0;
        for(IEstructuraNave nave : this.flotaNavesSiemples){
            distancia += nave.calcularDistancia();
        }
        return distancia/this.flotaNavesSiemples.size();
    }
}
