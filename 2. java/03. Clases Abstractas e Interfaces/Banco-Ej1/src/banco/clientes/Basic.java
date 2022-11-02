package banco.clientes;

import banco.operaciones.ConsultaSaldo;
import banco.operaciones.Extraccion;
import banco.operaciones.PagoServicio;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicio, Extraccion {
    @Override
    public void transaccionOk() {
        System.out.println("Operación Realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Operación Fallida!");
    }
}
