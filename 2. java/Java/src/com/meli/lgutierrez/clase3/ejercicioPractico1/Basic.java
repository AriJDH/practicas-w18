package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class Basic {

    private ConsultaSaldo consultaSaldo;
    private PagoServicio pagoServicio;
    private RetiroEfectivo retiroEfectivo;

    public Basic(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public Basic(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

    public Basic(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public Basic(ConsultaSaldo consultaSaldo, PagoServicio pagoServicio, RetiroEfectivo retiroEfectivo) {
        this.consultaSaldo = consultaSaldo;
        this.pagoServicio = pagoServicio;
        this.retiroEfectivo = retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public PagoServicio getPagoServicio() {
        return pagoServicio;
    }

    public void setPagoServicio(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public void setRetiroEfectivo(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }
}
