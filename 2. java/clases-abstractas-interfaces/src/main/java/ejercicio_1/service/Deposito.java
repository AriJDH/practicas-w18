package ejercicio_1.service;

import ejercicio_1.user.User;

public class Deposito implements service.ITransaccion {

    private User user;

    public void depositar(Integer amount, Boolean error){
        System.out.println("-------------------------------");
        System.out.println("Depositando en cuenta propia el monto de $" + amount);
        System.out.println("-------------------------------");
        if (error)
            transaccionNoOk();
        else {
            transaccionOk();
            user.setSaldo(user.getSaldo() + amount);
        }
    }
    public void depositar(Integer amount, Boolean error, User user){
        System.out.println("-------------------------------");
        System.out.println("Depositando en la cuenta de " + user.getNombre() + " el monto de $" + amount );
        System.out.println("-------------------------------");
        if (error)
            transaccionNoOk();
        else {
            transaccionOk();
            user.setSaldo(user.getSaldo() + amount);
        }

    }

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado. \n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito cancelado. \n");
    }

    public void setUser(User user) {
        this.user = user;
    }
}
