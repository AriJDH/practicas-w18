package com.meli.lgutierrez.complementario.ejercicio2;

import java.util.List;

public interface Componente {
    public double cercaniaAsteroide(List<Integer> coordenadasAsteroide);
    public int getPuntuacion();
    public void setPuntuacion(int puntuacion);
}
