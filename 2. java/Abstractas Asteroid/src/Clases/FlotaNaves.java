package Clases;

import Interfaces.INaves;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class FlotaNaves implements INaves {
    private String nombre;
    private List <Naves> flotaNaves;  //LISTA DE INAVES??? PORQUE NO DE NAVES SOLAS
    private double puntuacion;
    private double promedioPuntuacion;
    private double sumaDistancias;


    public FlotaNaves(String nombre) {
        this.nombre = nombre;
        this.flotaNaves= new ArrayList<>();
    }

    @Override
    public String getCoordenadas(){
        String texto = "";
        for(Naves naves : flotaNaves){
            texto= texto + ""+naves.getNombre()+"- X: " + naves.getXnave() + " Y: "+naves.getYnave() + " ";
        }
        return texto;
    }
    @Override
    public double calcularDistancia(int xBlanco, int yBlanco) {
        for(Naves naves : flotaNaves){
            sumaDistancias= sumaDistancias + naves.calcularDistancia(xBlanco,yBlanco);
        }
        return promedioPuntuacion= sumaDistancias/flotaNaves.size();
    }

    @Override
    public void setPuntuacion() {
        this.puntuacion += 1;
    }

    public void agregarNave(Naves nave){
        this.flotaNaves.add(nave);
    }

    public List<Naves> getFlotaNaves() {
        return flotaNaves;
    }

    public void setFlotaNaves(List<Naves> flotaNaves) {
        this.flotaNaves = flotaNaves;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPuntuacion() {
        return puntuacion;
    }


    public double getPromedioPuntuacion() {
        return promedioPuntuacion;
    }

    public void setPromedioPuntuacion(double promedioPuntuacion) {
        this.promedioPuntuacion = promedioPuntuacion;
    }

    public double getSumaDistancias() {
        return sumaDistancias;
    }

    public void setSumaDistancias(double sumaDistancias) {
        this.sumaDistancias = sumaDistancias;
    }
}
