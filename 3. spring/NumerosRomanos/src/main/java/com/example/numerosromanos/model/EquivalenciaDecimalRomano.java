package com.example.numerosromanos.model;

public class EquivalenciaDecimalRomano {
    private int decimal;
    private String romano;

    public EquivalenciaDecimalRomano(int decimal, String romano) {
        this.decimal = decimal;
        this.romano = romano;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public String getRomano() {
        return romano;
    }

    public void setRomano(String romano) {
        this.romano = romano;
    }
}
