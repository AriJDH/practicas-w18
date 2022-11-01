public class Cobradores {
    private RetiroDeEfectivo retiroDeEfectivo;
    private ConsultaDeSaldo consultaDeSaldo;
    private double monto;

    public Cobradores(){}
    public Cobradores(double monto){
        this.monto=monto;
    }

    public RetiroDeEfectivo getRetiroDeEfectivo() {
        return retiroDeEfectivo;
    }

    public void setRetiroDeEfectivo(RetiroDeEfectivo retiroDeEfectivo) {
        this.retiroDeEfectivo = retiroDeEfectivo;
    }

    public ConsultaDeSaldo getConsultaDeSaldo() {
        return consultaDeSaldo;
    }

    public void setConsultaDeSaldo(ConsultaDeSaldo consultaDeSaldo) {
        this.consultaDeSaldo = consultaDeSaldo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void realizaRetiroDeEfectivo(){
        retiroDeEfectivo = new RetiroDeEfectivo();
        if(monto>=1)
            retiroDeEfectivo.transaccionOK(monto);
        else
            retiroDeEfectivo.transaccionNoOk(monto);
    }

    public void realizaConsultaDeSaldo(){
        consultaDeSaldo = new ConsultaDeSaldo();
        if(monto>=1)
            consultaDeSaldo.transaccionOK(monto);
        else
            consultaDeSaldo.transaccionNoOk(monto);
    }
}
