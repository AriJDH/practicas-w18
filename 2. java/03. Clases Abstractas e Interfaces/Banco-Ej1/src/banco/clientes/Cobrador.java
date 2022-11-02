package banco.clientes;

import banco.operaciones.ConsultaSaldo;
import banco.operaciones.Extraccion;

public class Cobrador extends Cliente implements Extraccion, ConsultaSaldo {

    @Override
    public void transaccionOk() {
        System.out.println("Operación Realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Operación Fallida!");
    }
}
