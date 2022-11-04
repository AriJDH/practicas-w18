package ejercicio1.model;

import ejercicio1.interfaces.ITransaccion;

public abstract class Cliente implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Realizada con Exito !");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion Fallida !");
    }

    protected void randomizador() {

        switch ((int) Math.floor(Math.random() * (1 - 0 + 1))) {
            case 0:
                transaccionNoOk();
                break;
            case 1:
                transaccionOk();
                break;
        }
    }

}
