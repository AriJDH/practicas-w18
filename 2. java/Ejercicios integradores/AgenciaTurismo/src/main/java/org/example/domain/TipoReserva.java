package org.example.domain;

public enum TipoReserva {
    HOTEL("Hotel"),
    COMIDA("Comida"),
    BOLETO_VIAJE("Boleto de viaje"),
    TRANSPORTE("Transporte");

    private String codigo;

    TipoReserva(String val) {
        this.codigo = val;
    }

    @Override
    public String toString(){
        return this.codigo;
    }
}
