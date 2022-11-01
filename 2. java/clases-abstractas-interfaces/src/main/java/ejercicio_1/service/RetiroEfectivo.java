package ejercicio_1.service;

import ejercicio_1.user.User;

public class RetiroEfectivo implements service.ITransaccion {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void retirarEfectivo(double cantidadARetirar) {
        System.out.println("Retirando efectivo");
        System.out.println("--------------------------------");
        if(user.getSaldo() < cantidadARetirar )
            transaccionOk();
        else {
            user.setSaldo(user.getSaldo() - cantidadARetirar);
            transaccionOk();
        }

    }

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de dinero realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro cancelado.");
    }

}
