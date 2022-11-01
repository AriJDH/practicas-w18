package user;

import service.ConsultaSaldo;
import service.RetiroEfectivo;

public class Cobrador extends User{
    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        this.retiroEfectivo = retiroEfectivo;
        this.consultaSaldo = consultaSaldo;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        retiroEfectivo.setUser(this);
        return retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        consultaSaldo.setUser(this);
        return consultaSaldo;
    }
}
