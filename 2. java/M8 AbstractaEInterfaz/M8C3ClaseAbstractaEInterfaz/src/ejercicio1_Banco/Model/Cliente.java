package ejercicio1_Banco.Model;

public abstract class Cliente {
    private double saldo;

    public Cliente(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
