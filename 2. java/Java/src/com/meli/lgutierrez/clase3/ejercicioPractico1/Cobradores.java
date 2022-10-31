package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class Cobradores {
    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobradores(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public Cobradores(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public Cobradores(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        this.retiroEfectivo = retiroEfectivo;
        this.consultaSaldo = consultaSaldo;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public void setRetiroEfectivo(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }
}
