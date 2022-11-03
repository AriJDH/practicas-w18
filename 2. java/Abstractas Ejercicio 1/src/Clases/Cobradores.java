package Clases;

import Interfaces.ConsultaSaldo;
import Interfaces.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public String decirSaldo() {
        return "Su saldo es...";
    }

    @Override
    public String retirarEfectivo() {
        return "Retirando efectivo...";
    }

    @Override
    public String transaccionOk() {
        return "Su retiro/consulta saldo fue exitoso";
    }

    @Override
    public String transaccionNoOk() {
        return "Su retiro/consulta saldo fue rechazado";
    }
}
