package InterfacesYClaseAbstractas.banco.clases;

public class OperacionesBancarias {
    public static void main(String[] args) {
        Cobradores cobrador = new Cobradores();
        cobrador.consultarSaldo();
        cobrador.extraerEfectivo(5000.00);
    }
}
