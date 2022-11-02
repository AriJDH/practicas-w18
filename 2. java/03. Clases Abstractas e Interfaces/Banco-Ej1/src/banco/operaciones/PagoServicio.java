package banco.operaciones;

public interface PagoServicio {
    default void pagarServicio() {
        System.out.println("Pagando un Servicio.");
    }

}
