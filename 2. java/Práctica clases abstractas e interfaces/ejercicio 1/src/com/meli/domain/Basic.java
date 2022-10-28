package com.meli.domain;

public class Basic extends Persona{
    public Basic(String nombre) {
        super(nombre);
    }

    public void confirmarConsultaSaldo(){
        (new ConsultaSaldo()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarConsultaSaldo(){
        (new ConsultaSaldo()).transaccionNoOk();
        super.confirmarOperacion();
    }

    public void confirmarPagoServicio(){
        (new PagoServicios()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarPagoServicio(){
        (new PagoServicios()).transaccionNoOk();
        super.confirmarOperacion();
    }

    public void confirmarRetiro(){
        (new RetiroEfectivo()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarRetiro(){
        (new RetiroEfectivo()).transaccionNoOk();
        super.confirmarOperacion();
    }
}
