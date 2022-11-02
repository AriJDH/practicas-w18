package banco.operaciones;

public interface Extraccion extends Transaccion{
    default void retirarEfectivo() {
        System.out.println("Realizando Extracción.");
    }
}
