package com.meli.domain;

public class Cobrador extends Persona{
    public Cobrador(String nombre) {
        super(nombre);
    }

    public void confirmarRetiroEfectivo(){
        (new RetiroEfectivo()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarRetiroEfectivo(){
        (new RetiroEfectivo()).transaccionNoOk();
        super.confirmarOperacion();
    }

    public void confirmarConsultaSaldo(){
        (new ConsultaSaldo()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarConsultaSaldo(){
        (new ConsultaSaldo()).transaccionNoOk();
        super.confirmarOperacion();
    }
}
