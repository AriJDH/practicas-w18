package com.meli.domain;

public class Ejecutivo extends Persona {
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    public void confirmarDeposito(){
        (new Deposito()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarDeposito(){
        (new Deposito()).transaccionNoOk();
        super.confirmarOperacion();
    }

    public void confirmarTransferencia(){
        (new Transferencia()).transaccionOk();
        super.confirmarOperacion();
    }

    public void cancelarTransferencia(){
        (new Transferencia()).transaccionNoOk();
        super.confirmarOperacion();
    }

}
