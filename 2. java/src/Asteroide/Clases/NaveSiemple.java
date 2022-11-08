package Asteroide.Clases;

import Asteroide.Shapes.IEstructuraNave;

import java.util.ArrayList;
import java.util.List;

public class NaveSiemple implements IEstructuraNave {
    public NaveSiemple() {
    }
    private String nombreNave;
    private List<Integer> coordenadasNave;
    private List<Integer> coordenadasAsteroide;
    private int puntaje;

    @Override
    public void agregarNave(IEstructuraNave nave) {

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

        return (float)Math.sqrt(
                Math.pow((this.coordenadasNave.get(0)-this.coordenadasAsteroide.get(0)),2)
                +
                Math.pow((this.coordenadasNave.get(1)-this.coordenadasAsteroide.get(1)),2));
    }
}
