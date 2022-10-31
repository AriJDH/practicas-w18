package clase3_a_ClasesAbsEInterfaces.Ejercicio1;

public interface Transaccionable {

    public abstract void transaccionOk(String tipoTransacc);
    public abstract void transaccionNoOk(String tipoTransacc);
}
