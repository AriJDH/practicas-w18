package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDescuentos {
    private static CalculadorDescuentos instancia = null;
    private static List<EstrategiaDeDescuento> estrategiasDeDescuento = new ArrayList<>();

    public static CalculadorDescuentos instancia(){
        if(instancia==null){
            instancia=new CalculadorDescuentos();
            estrategiasDeDescuento.add(new DescuentoPor2Localizadores());
            estrategiasDeDescuento.add(new DescuentoPorPaqueteCompleto());
            estrategiasDeDescuento.add(new DescuentoPorReservasDeHotelBoletos());
            return instancia;
        }else
            return instancia;
    }

    public double calcularDescuentos(Localizador localizador){
        return estrategiasDeDescuento.stream().mapToDouble(estrategia-> estrategia.calcularDescuento(localizador)).sum();
    }
}
