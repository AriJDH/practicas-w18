package ejercicio_1.user;

import ejercicio_1.service.ConsultaSaldo;
import ejercicio_1.service.PagoServicio;
import ejercicio_1.service.RetiroEfectivo;

public class Basic extends User{

    private ConsultaSaldo consultaSaldo;
    private PagoServicio pagoServicio;
    private RetiroEfectivo retiroEfectivo;

    public Basic(ConsultaSaldo consultaSaldo, PagoServicio pagoServicio, RetiroEfectivo retiroEfectivo) {
        this.consultaSaldo = consultaSaldo;
        this.pagoServicio = pagoServicio;
        this.retiroEfectivo = retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        consultaSaldo.setUser(this);
        return consultaSaldo;
    }

    public PagoServicio getPagoServicio() {
        pagoServicio.setUser(this);
        return pagoServicio;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        retiroEfectivo.setUser(this);
        return retiroEfectivo;
    }
}
