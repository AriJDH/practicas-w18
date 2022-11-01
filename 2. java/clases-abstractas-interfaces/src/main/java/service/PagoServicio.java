package service;

import user.User;

public class PagoServicio implements ITransaccion {
    private User user;

    public void pagarServicio(String nombreServicio, double amount){
        System.out.println("Pagando $" + amount + " del servicio " + nombreServicio);
        if(amount > user.getSaldo())
            transaccionNoOk();
        else {
            transaccionOk();
            user.setSaldo( user.getSaldo() - amount);
        }
    }
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio cancelado.");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
