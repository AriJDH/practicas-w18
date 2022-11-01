public class Basic {
    private ConsultaDeSaldo consultaDeSaldo;
    private PagoDeServicios pagoDeServicios;
    private RetiroDeEfectivo retiroDeEfectivo;
    private double monto;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ConsultaDeSaldo getConsultaDeSaldo() {
        return consultaDeSaldo;
    }

    public void setConsultaDeSaldo(ConsultaDeSaldo consultaDeSaldo) {
        this.consultaDeSaldo = consultaDeSaldo;
    }

    public PagoDeServicios getPagoDeServicios() {
        return pagoDeServicios;
    }

    public void setPagoDeServicios(PagoDeServicios pagoDeServicios) {
        this.pagoDeServicios = pagoDeServicios;
    }

    public RetiroDeEfectivo getRetiroDeEfectivo() {
        return retiroDeEfectivo;
    }

    public void setRetiroDeEfectivo(RetiroDeEfectivo retiroDeEfectivo) {
        this.retiroDeEfectivo = retiroDeEfectivo;
    }

    public Basic(){}
    public Basic(double monto){
        this.monto = monto;
    }

    public void realizaConsultaDeSaldo(){
        consultaDeSaldo = new ConsultaDeSaldo();
        if(monto>=1)
            consultaDeSaldo.transaccionOK(monto);
        else
            consultaDeSaldo.transaccionNoOk(monto);
    }

    public void realizaPagoDeServicios(){
        pagoDeServicios = new PagoDeServicios();
        if(monto>=1)
            pagoDeServicios.transaccionOK(monto);
        else
            pagoDeServicios.transaccionNoOk(monto);
    }

    public void realizaRetiroDeEfectivo(){
        retiroDeEfectivo = new RetiroDeEfectivo();
        if(monto>=1)
            retiroDeEfectivo.transaccionOK(monto);
        else
            retiroDeEfectivo.transaccionNoOk(monto);
    }
}
