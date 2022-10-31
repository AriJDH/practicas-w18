package InterfacesYClaseAbstractas.banco.interfaces;

public interface PagarServicios extends Transacciones{
    public void pagarServicio(String servicio, Double monto);
}
