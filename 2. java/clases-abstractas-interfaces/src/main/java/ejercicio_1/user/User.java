package ejercicio_1.user;

public class User {
    private String nombre;
    private double saldo;

    public User(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public User() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void imprimirDatosDeCuenta() {
        System.out.println(toString());
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "User {" +
                "nombre = '" + nombre + '\'' +
                ", saldo = $" + saldo +
                '}';
    }
}
