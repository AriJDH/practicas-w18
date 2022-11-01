package service;

import user.User;

public class ConsultaSaldo implements ITransaccion {
    private User user;

    public void mostrarSaldo(boolean error){
        System.out.println("Consultando con base de datos saldo");
        System.out.println("--------------------------------");
        if (error)
            transaccionOk();
        else {
            transaccionOk();
            System.out.println("Saldo en cuenta: " + user.getSaldo());
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo cancelada.");
    }

    public void setUser(User user) {
        this.user = user;
    }
}
