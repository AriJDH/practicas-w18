package ejercicio_1.service;

import ejercicio_1.user.User;

public class Transferencia implements service.ITransaccion {
    private User user;

    public void transferir(String CBU, double cantidadATransferir) {
        System.out.println("Transferiendo $" + cantidadATransferir + " a " + CBU);
        System.out.println("--------------------------------");
        transaccionOk();
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizada");
    }

}
