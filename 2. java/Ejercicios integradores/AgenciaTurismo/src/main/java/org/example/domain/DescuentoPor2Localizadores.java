package org.example.domain;

public class DescuentoPor2Localizadores implements EstrategiaDeDescuento{
    @Override
    public double calcularDescuento(Localizador localizador) {
        return localizador.getCliente().cantidadLocalizadores()>=2? 0.05*localizador.getTotal(): 0;
    }
}
